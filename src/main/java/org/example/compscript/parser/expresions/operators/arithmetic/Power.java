package org.example.compscript.parser.expresions.operators.arithmetic;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Power extends Instruction {

    private Instruction opLeft;
    private Instruction opRight;

    public Power(Instruction opLeft, Instruction opRight, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.opLeft = opLeft;
        this.opRight = opRight;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        String desc = "Invalid power operation between types";

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
                        this.type.setType(dataType.WHOLE);
                        return (int) Math.pow ((int) leftValue, (int) rightValue);
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return Math.pow ((int) leftValue, (double) rightValue);
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
                        return Math.pow ((double) leftValue, (int) rightValue);
                    }
                    case DOUBLE -> {
                        this.type.setType(dataType.DOUBLE);
                        return Math.pow ((double) leftValue, (double) rightValue);
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
