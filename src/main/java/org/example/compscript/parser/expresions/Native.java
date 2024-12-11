package org.example.compscript.parser.expresions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.SymbolsTable;

public class Native extends Instruction {

    public Object value;

    public Native(Object value, Type type, int line, int column) {
        super(type, line, column);
        this.value = value;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        return this.value;
    }
}
