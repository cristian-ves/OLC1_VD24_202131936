package org.example.compscript.parser.instructions.declarations;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Declaration extends Instruction {

    private String id;
    private Instruction value;
    private boolean isMutable;
    private Object defaultValue;
    private LinkedList<Instruction> expressions;

    public Declaration(String isMutable, String id, Type type, Instruction value, int line, int column) {
        super(type, line, column);
        this.isMutable = Boolean.parseBoolean(isMutable);
        this.id = id;
        this.value = value;
    }

    public Declaration(String isMutable, String id, Type type, int line, int column) {
        super(type, line, column);
        this.isMutable = Boolean.parseBoolean(isMutable);
        this.id = id;
        this.defaultValue = switch (type.getType()) {
            case WHOLE -> 0;
            case DOUBLE -> 0.0;
            case BOOLEAN -> true;
            case CHAR -> '\u0000';
            case STRING -> "";
            default ->  new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid type for declaration: " + type.getType(),
                    line,
                    column
            );
        };
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        if(value == null){
            if(defaultValue instanceof CompError) return defaultValue;

            return (symbolsTable.setVariable(new Symbol_(this.type, this.id, defaultValue, isMutable))) ?
                    null :
                    new CompError(ErrorType.SEMANTIC, "Variable " + this.id + " already exists", this.line, this.column);
        }

        var interpretedValue = this.value.interpret(tree, symbolsTable);
        if (interpretedValue instanceof CompError) return interpretedValue;

        if(this.value.type.getType() != this.type.getType()) // types are not matching
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid declaration, type required: " + type.getType() + ". type provided: " + this.value.type.getType(),
                    line,
                    column
            );

        //validate if variable exists and declare it
        return (symbolsTable.setVariable(new Symbol_(this.type, this.id, interpretedValue, isMutable))) ?
                null :
                new CompError(ErrorType.SEMANTIC, "Variable " + this.id + " already exists", this.line, this.column);
    }
}
