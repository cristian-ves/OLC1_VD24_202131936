package org.example.compscript.parser.expresions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class EqualsTo extends Instruction {

    private Instruction leftExp;
    private Instruction rightExp;

    public EqualsTo(Instruction leftExp, Instruction rightExp, int line, int column) {
        super(new Type(dataType.BOOLEAN), line, column);
        this.leftExp = leftExp;
        this.rightExp = rightExp;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        String desc = "Invalid relational combination ==";

        var res1 = this.leftExp.interpret(tree, symbolsTable);
        if(res1 instanceof Error) {
            return res1;
        }

        var res2 = this.rightExp.interpret(tree, symbolsTable);
        if(res2 instanceof Error) {
            return res2;
        }

        var type1 = this.leftExp.type.getType();
        var type2 = this.rightExp.type.getType();

        switch (type1) {
            case WHOLE -> {
                return switch (type2) {
                    case WHOLE -> (int) res1 == (int) res2;
                    case DOUBLE -> (int) res1 == (double) res2;
                    default -> new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                };
            }
            case DOUBLE ->  {
                return switch (type2) {
                    case WHOLE -> (double) res1 == (int) res2;
                    case DOUBLE -> (double) res1 == (double) res2;
                    default -> new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                };
            }
            case STRING -> {
                return switch (type2) {
                    case STRING -> ((String) res1).equals((String) res2);
                    default -> new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
                };
            }
            default -> {
                return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);
            }
        }
    }
}