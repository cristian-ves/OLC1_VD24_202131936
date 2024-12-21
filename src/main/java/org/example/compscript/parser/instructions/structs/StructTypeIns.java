package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;

import java.sql.Struct;

public class StructTypeIns extends Instruction {

    private String id;

    public StructTypeIns(String id, Type type, int line, int column) {
        super(type, line, column);
        this.id = id;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        StructType structType = new StructType(id, type);
        return structType;
    }
}
