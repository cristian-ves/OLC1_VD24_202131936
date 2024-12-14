package org.example.compscript.parser.instructions.match;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class Default extends Instruction {

    private LinkedList<Instruction> instructions;

    public Default(LinkedList<Instruction> instructions, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.instructions = instructions;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        for (var i: this.instructions) {
            var res = i.interpret(tree, symbolsTable);
            if (res instanceof CompError) tree.addError((CompError) res);
        }
        return null;
    }
}
