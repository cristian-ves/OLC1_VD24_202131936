package org.example.compscript.parser.expresions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.Error;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;
import org.example.compscript.parser.symbol.SymbolsTable;

public class Addition extends Instruction {

    private Instruction opLeft;
    private Instruction opRight;

    public Addition(Instruction opLeft, Instruction opRight, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.opLeft = opLeft;
        this.opRight = opRight;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        String desc = "Invalid sum between types";

        var leftValue = this.opLeft.interpret(tree, symbolsTable);
        if (leftValue instanceof Error) {
            return leftValue;
        }

        var rightValue = this.opRight.interpret(tree, symbolsTable);
        if (rightValue instanceof Error) {
            return rightValue;
        }

        var leftType = opLeft.type.getType();
        var rightType = opRight.type.getType();

        System.out.println(leftType + " " + rightType);
        System.out.println(leftValue + " " + rightValue);

        switch (leftType) {
            case WHOLE -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.WHOLE);
                        return (int) leftValue + (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (int) leftValue + (double) rightValue;
                    }
                    default -> {
                        return new Error(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }

            case DOUBLE -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue + (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue + (double) rightValue;
                    }
                    default -> {
                        return new Error(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }

            default -> {
                return new Error(ErrorType.SEMANTIC, desc, this.line, this.column);
            }
        }

    }
}
