package org.example.compscript.parser.expresions.operators.arithmetic;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Division extends Instruction {

    private Instruction opLeft;
    private Instruction opRight;

    public Division(Instruction opLeft, Instruction opRight, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.opLeft = opLeft;
        this.opRight = opRight;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        String desc = "Invalid division between types";

        var leftValue = this.opLeft.interpret(tree, symbolsTable);
        if (leftValue instanceof CompError) {
            return  leftValue;
        }

        var rightValue = this.opRight.interpret(tree, symbolsTable);
        if (rightValue instanceof CompError) {
            return  opRight;
        }

        var leftType = opLeft.type.getType();
        var rightType = opRight.type.getType();

        switch (leftType) {
            case WHOLE -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) (int) leftValue / (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (int) leftValue / (double) rightValue;
                    }
                    case CHAR -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) (int) leftValue / (char) rightValue;
                    }
                    default -> {
                        return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }
            case DOUBLE -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue / (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue / (double) rightValue;
                    }
                    case CHAR -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue / (char) rightValue;
                    }
                    default -> {
                        return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }
            case CHAR -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.WHOLE);
                        return (double) (char) leftValue / (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (char) leftValue / (double) rightValue;
                    }
                    default -> {
                        return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }
            default -> {
                return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
            }
        }

    }

}
