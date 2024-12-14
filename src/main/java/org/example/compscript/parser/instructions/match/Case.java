package org.example.compscript.parser.instructions.match;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class Case extends Instruction {

    private Instruction expression;
    private Instruction expresionToEval;
    private LinkedList<Instruction> instructions;
    private boolean wasExecuted;

    public Case(Instruction expression, LinkedList<Instruction> instructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.expression = expression;
        this.instructions = instructions;
    }

    public void setExpresionToEval(Instruction expresionToEval) {
        this.expresionToEval = expresionToEval;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        this.wasExecuted = false;

        var res1 = this.expression.interpret(tree, symbolsTable);
        var res2 = this.expresionToEval.interpret(tree, symbolsTable);

        dataType type1 = this.expression.type.getType();
        dataType type2 = this.expresionToEval.type.getType();

        if(type1 != type2) {
            return new CompError(
                    ErrorType.SEMANTIC,
                    "types not matching: " + type1.getValue() + " and " + type2.getValue(),
                    this.line,
                    this.column
            );
        }

        var equals = switch(type1) {
            case WHOLE ->
                 switch (type2) {
                    case WHOLE -> (int) res1 == (int) res2;
                    case DOUBLE -> (int) res1 == (double) res2;
                    case CHAR -> (int) res1 == (char) res2;
                    default -> generateCompError(type1, type2);
                };
            case DOUBLE ->
                switch (type2) {
                    case WHOLE -> (double) res1 == (int) res2;
                    case DOUBLE -> (double) res1 == (double) res2;
                    case CHAR -> (double) res1 == (char) res2;
                    default -> generateCompError(type1, type2);
                };
            case BOOLEAN ->
                (type2 == dataType.BOOLEAN) ?
                        (boolean) res1 == (boolean) res2 :
                        new CompError(
                            ErrorType.SEMANTIC,
                            "type " + type1 + " cannot be matched with " + type2,
                            this.line,
                            this.column
                        );
            case CHAR ->
                 switch (type2) {
                    case WHOLE -> (char) res1 == (int) res2;
                    case DOUBLE -> (char) res1 == (double) res2;
                    case CHAR -> (char) res1 == (char) res2;
                    default -> generateCompError(type1, type2);
                };
            case STRING ->
                (type2 == dataType.STRING) ?
                        ((String) res1).equals((String) res2) :
                        generateCompError(type1, type2);
            default -> generateCompError(type1, type2);
        };

        if(equals instanceof CompError) return equals;

        if((boolean) equals){
            for (var i: this.instructions) {
                var res = i.interpret(tree, symbolsTable);
                if (res instanceof CompError) tree.addError((CompError) res);
            }
            this.wasExecuted = true;
        }

        return null;

    }

    public CompError generateCompError (dataType type1, dataType type2) {
        return new CompError(
                ErrorType.SEMANTIC,
                "type " + type1 + " cannot be matched with " + type2,
                this.line,
                this.column
        );
    }

    public boolean getWasExecuted () {
        return this.wasExecuted;
    }

}
