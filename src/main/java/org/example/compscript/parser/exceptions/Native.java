package org.example.compscript.parser.exceptions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.symbolsTable;

public class Native extends Instruction {

    public Object value;

    public Native(Object value, Type type, int line, int column) {
        super(type, line, column);
        this.value = value;
    }

    @Override
    public Object interpret(Tree tree, symbolsTable symbolsTable) {
        return this.value;
    }
}
