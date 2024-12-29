package org.example.compscript.parser.instructions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class If extends Instruction {

    private Instruction condition;
    private LinkedList<Instruction> instructions;
    private Instruction elseCondition;
    private LinkedList<Instruction> elseInstructions;

    public If(Instruction condition, LinkedList<Instruction> instructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.condition = condition;
        this.instructions = instructions;
    }

    public If(Instruction condition, LinkedList<Instruction> instructions, LinkedList<Instruction> elseInstructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.condition = condition;
        this.instructions = instructions;
        if (elseInstructions != null && !elseInstructions.isEmpty())
            this.elseInstructions = elseInstructions;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var cond = this.condition.interpret(tree, symbolsTable);
        if(cond instanceof CompError) return cond;

        if(this.condition.type.getType() != dataType.BOOLEAN)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "if expression has to be boolean",
                    this.line,
                    this.column
            );

        // creating new environment
        var newTable = new SymbolsTable(symbolsTable, STableType.IF);
        if((boolean) cond){
            for (var i: this.instructions) {
                if(i== null) continue;
                var res = i.interpret(tree, newTable);
                if (res instanceof CompError) tree.addError((CompError) res);
            }
        } else if (this.elseInstructions != null){

            if(elseCondition != null) {
                // elseif
                if((boolean) elseCondition.interpret(tree, newTable)) {
                    for (var i: this.elseInstructions) {
                        if(i == null) continue;
                        var res = i.interpret(tree, newTable);
                        if (res instanceof CompError) tree.addError((CompError) res);
                    }
                }
                return null;
            }

            for (var i: this.elseInstructions) {
                if(i == null) continue;
                var res = i.interpret(tree, newTable);
                if(res instanceof CompError) tree.addError((CompError) res);
            }

        }

        return null;

    }
}
