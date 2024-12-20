package org.example.compscript.parser.instructions.assignments;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

public class Assignment extends Instruction {

    private String id;
    private Instruction newValue;

    public Assignment(String id, Instruction newValue, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.newValue = newValue;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var resultNewValue = this.newValue.interpret(tree, symbolsTable);
        if(resultNewValue instanceof CompError) return resultNewValue;

        int code = symbolsTable.putVariable(id, new Symbol_(this.newValue.type, this.id, resultNewValue));

        return switch (code) {
            case 0 -> new CompError(
                    ErrorType.SEMANTIC,
                    "The variable " + id + " hasn't been declared",
                    this.line,
                    this.column
            );
            case 1 -> new CompError(
                    ErrorType.SEMANTIC,
                    "The const variable " + id + " is immutable",
                    this.line,
                    this.column
            );
            case 2 -> resultNewValue;
            default -> new CompError(
                    ErrorType.SEMANTIC,
                    "The assignment types are not matching, expecting: " +
                            symbolsTable.getVariable(id).getType().getType().getValue() + ", provided: " + newValue.type.getType().getValue(),
                    this.line,
                    this.column
            );
        };
    }
}
