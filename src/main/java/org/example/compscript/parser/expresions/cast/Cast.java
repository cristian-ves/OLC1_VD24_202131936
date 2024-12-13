package org.example.compscript.parser.expresions.cast;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Cast extends Instruction {

    private Instruction expression;

    public Cast(Instruction expression, Type type, int line, int column) {
        super(type, line, column);
        this.expression = expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var res = expression.interpret(tree, symbolsTable);
        if(res instanceof CompError) {
            return res;
        }

        var expType = expression.type.getType();

        switch (type.getType()) {
            case DOUBLE -> {
                return switch (expType) {
                    case WHOLE -> (double) ((int) res);
                    case CHAR -> (double) ((char) res);
                    default -> new CompError(ErrorType.SEMANTIC, "Invalid cast type " + expType.getValue() + " to double", line, column);
                };
            }
            case WHOLE -> {
                return switch (expType) {
                    case DOUBLE -> (int) ((double) res);
                    case CHAR -> (int) ((char) res);
                    default -> new CompError(ErrorType.SEMANTIC, "Invalid cast type " + expType.getValue() + " to int", line, column);
                };
            }
            case CHAR -> {
                return (expType == dataType.WHOLE)
                        ? (char) ((int) res) :
                        new CompError(ErrorType.SEMANTIC, "Invalid cast type " + expType.getValue() + " to char", line, column);
            }
            default -> {
                return new CompError(ErrorType.SEMANTIC, "Invalid cast types " + expType.getValue() + " to " + type.getType().getValue(), line, column);
            }
        }
    }
}
