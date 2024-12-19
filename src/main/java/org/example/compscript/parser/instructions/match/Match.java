package org.example.compscript.parser.instructions.match;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Match extends Instruction {

    private Instruction expression;
    private LinkedList<Instruction> instructions;
    private boolean hasDefault;

    public Match(Instruction expression, LinkedList<Instruction> instructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.expression = expression;
        this.instructions = instructions;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        int j = 1;
        for (Instruction i: this.instructions) {
            var newTable = new SymbolsTable(symbolsTable, STableType.MATCH);

//            if(!(hasDefault && j == this.instructions.size()))
//                ((Case) i).setExpresionToEval(this.expression);

            try {
                ((Case) i).setExpresionToEval(this.expression);
                i.interpret(tree, newTable);
                if(((Case) i).getWasExecuted()) return null;
            } catch (ClassCastException e) {
                i.interpret(tree, newTable);
            }

            j++;
        }

        return null;
    }
}
