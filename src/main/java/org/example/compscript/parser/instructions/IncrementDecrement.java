package org.example.compscript.parser.instructions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

public class IncrementDecrement extends Instruction {

    String id;
    String type;

    public IncrementDecrement(String id, String type, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.type = type;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        Symbol_ symbol = symbolsTable.getVariable(id);

        if(symbol == null) return new CompError(
                ErrorType.SEMANTIC,
                "The variable " + id + " is not declared.",
                this.line,
                this.column
        );

        boolean isPlus = (type.equals("plus"));

        dataType symbolType = symbol.getType().getType();
        if (symbolType == dataType.DOUBLE ||
            symbolType == dataType.WHOLE){

            if(symbol.isMutable()) {

                if(symbolType == dataType.DOUBLE) {
                    double newValue = ((double) symbol.getValue()) + (isPlus ? 1 : -1);
                    symbolsTable.putVariable(id, new Symbol_(symbol.getType(), id, newValue, true));
                    return null;
                }

                int newValue = ((int) symbol.getValue()) + (isPlus ? 1 : -1);
                symbolsTable.putVariable(id, new Symbol_(symbol.getType(), id, newValue, true));
                return null;

            }

            return new CompError(
                    ErrorType.SEMANTIC,
                    "The variable " + id + " is not mutable",
                    this.line,
                    this.column
            );

        }

        String aux = isPlus ? "incremented" : "decremented";
        return new CompError(
                ErrorType.SEMANTIC,
                  symbolType.getValue() + " type cannot be " + aux,
                this.line,
                this.column
        );

    }
}
