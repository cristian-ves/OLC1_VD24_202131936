package org.example.compscript.parser.instructions.loop;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class While extends Instruction {
    private Instruction condition;
    private LinkedList<Instruction> instructions;

    public While(Instruction condition, LinkedList<Instruction> instructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.condition = condition;
        this.instructions = instructions;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var cond = this.condition.interpret(tree, symbolsTable);
        if (cond instanceof CompError) return cond;
        if (this.condition.type.getType() != dataType.BOOLEAN)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Condition of for loop must be boolean",
                    this.line,
                    this.column
            );


        while((boolean) this.condition.interpret(tree, symbolsTable)) {
            var newTable = new SymbolsTable(symbolsTable);

            for (var instruction : this.instructions) {
                var resInst = instruction.interpret(tree, newTable);
            }
        }

        return null;

    }
}
