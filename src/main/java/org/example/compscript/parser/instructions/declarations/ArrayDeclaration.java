package org.example.compscript.parser.instructions.declarations;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.Symbol_;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;

import java.util.LinkedList;

public class ArrayDeclaration extends Instruction {

    private String id;
    private LinkedList<Object> value;
    private boolean isMutable;
    private LinkedList<Instruction> expressions;

    public ArrayDeclaration(String isMutable, String id, Type type, LinkedList<Instruction> expressions, int line, int column) { //arrays
        super(type, line, column);
        this.isMutable = Boolean.parseBoolean(isMutable);
        this.id = id;
        this.expressions = expressions;
        this.value = new LinkedList<Object>();
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        boolean idNotUsed = symbolsTable.setVariable(new Symbol_(this.type, this.id, value, this.isMutable));

        if (!idNotUsed) return new
                CompError(
                ErrorType.SEMANTIC,
                "Variable " + this.id + " already exists",
                this.line,
                this.column
        );

        for (Instruction ins : expressions) {
            var interpretedIns = ins.interpret(tree, symbolsTable);
            if (interpretedIns instanceof CompError) return interpretedIns;

            if (ins.type.getType() != this.type.getType()) {
                return new CompError(
                        ErrorType.SEMANTIC,
                        "Invalid array expression, type required: " + type.getType().getValue() + ". type provided: " + ins.type.getType().getValue(),
                        line,
                        column
                );
            }

            value.add(interpretedIns);
        }

        return null;
    }
}
