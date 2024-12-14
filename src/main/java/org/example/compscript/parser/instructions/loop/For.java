package org.example.compscript.parser.instructions.loop;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class For extends Instruction {
    private Instruction asignment;
    private Instruction condition;
    private Instruction step;
    private LinkedList<Instruction> instructions;

    public For(Instruction asignment, Instruction condition, Instruction step, LinkedList<Instruction> instructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.asignment = asignment;
        this.condition = condition;
        this.step = step;
        this.instructions = instructions;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var res1 = this.asignment.interpret(tree, symbolsTable);
        if (res1 instanceof CompError) return res1;

        var res2 = this.condition.interpret(tree, symbolsTable);
        if (res2 instanceof CompError) return res2;
        if (this.condition.type.getType() != dataType.BOOLEAN)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Condition of for loop must be boolean",
                    this.line,
                    this.column
                    );

        var newTable = new SymbolsTable(symbolsTable);

        while((boolean) this.condition.interpret(tree, newTable)){
            var newTable2 = new SymbolsTable(newTable);

            for (var instruction : this.instructions) {
                var resInst = instruction.interpret(tree, newTable2);
                if (resInst instanceof Break) return null;
            }
            var step = this.step.interpret(tree, newTable);
            if(step instanceof CompError) return step;
        }
        return null;
    }

}
