package org.example.compscript.parser.abstract_;

import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.symbolsTable;

public abstract class Instruction {

    public Type type;
    public int line;
    public int column;

    public Instruction(Type type, int line, int column) {
        this.type = type;
        this.line = line;
        this.column = column;
    }

    public abstract Object interpret(Tree tree, symbolsTable symbolsTable);

}
