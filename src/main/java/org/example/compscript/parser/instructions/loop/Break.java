package org.example.compscript.parser.instructions.loop;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Break extends Instruction {

    public Break(int line, int column) {
        super(new Type(dataType.VOID), line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        return null;
    }
}
