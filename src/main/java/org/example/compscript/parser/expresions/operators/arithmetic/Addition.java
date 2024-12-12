package org.example.compscript.parser.expresions.operators.arithmetic;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
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
        if (leftValue instanceof CompError) {
            return leftValue;
        }

        var rightValue = this.opRight.interpret(tree, symbolsTable);
        if (rightValue instanceof CompError) {
            return rightValue;
        }

        var leftType = opLeft.type.getType();
        var rightType = opRight.type.getType();

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
                    case BOOLEAN -> {
                        this.type.setType(dataType.WHOLE);
                        int booleanValue = (Boolean) rightValue ? 1 : 0;
                        return (int) leftValue + booleanValue;
                    }
                    case CHAR -> {
                        this.type.setType(dataType.WHOLE);
                        return (int) leftValue + (char) rightValue;
                    }
                    case STRING -> {
                        this.type.setType(dataType.STRING);
                        return (int) leftValue + (String) rightValue;
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
                            return (double) leftValue + (int) rightValue;
                        }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue + (double) rightValue;
                    }
                    case BOOLEAN -> {
                        this.type.setType(dataType.DOUBLE);
                        int booleanValue = (Boolean) rightValue ? 1 : 0;
                        return (double) leftValue + booleanValue;
                    }
                    case CHAR -> {
                        this.type.setType(dataType.DOUBLE);
                        return (double) leftValue + (char) rightValue;
                    }
                    case STRING -> {
                        this.type.setType(dataType.STRING);
                        return (double) leftValue + (String) rightValue;
                    }
                    default -> {
                        return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }

            case BOOLEAN -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.WHOLE);
                        int booleanValue = (Boolean) leftValue ? 1 : 0;
                        return booleanValue + (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        int booleanValue = (Boolean) leftValue ? 1 : 0;
                        return booleanValue + (double) rightValue;
                    }
                    case STRING -> {
                        this.type.setType(dataType.STRING);
                        return (boolean) leftValue + (String) rightValue;
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
                        return (char) leftValue + (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return (char) leftValue + (double) rightValue;
                    }
                    case CHAR -> {
                        this.type.setType(dataType.STRING);
                        return (char) leftValue + (char) rightValue;
                    }
                    case STRING -> {
                        this.type.setType(dataType.STRING);
                        return (char) leftValue + (String) rightValue;
                    }
                    default -> {
                        return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                    }
                }
            }

            case STRING -> {
                switch (rightType) {
                    case WHOLE -> {
                        this.type.setType(dataType.STRING);
                        return (String) leftValue + (int) rightValue;
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.STRING);
                        return (String) leftValue + (double) rightValue;
                    }
                    case BOOLEAN -> {
                        this.type.setType(dataType.STRING);
                        return (String) leftValue + (boolean) rightValue;
                    }
                    case CHAR -> {
                        this.type.setType(dataType.STRING);
                        return (String) leftValue + (char) rightValue;
                    }
                    case STRING -> {
                        this.type.setType(dataType.STRING);
                        return (String) leftValue + (String) rightValue;
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
