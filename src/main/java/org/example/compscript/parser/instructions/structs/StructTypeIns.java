package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.sql.Struct;

public class StructTypeIns extends Instruction {

    private String id;
    private String subStructId;

    public StructTypeIns(String id, Type type, int line, int column) {
        super(type, line, column);
        this.id = id;
    }

    public StructTypeIns(String id, String subStructId, int line, int column) {
        super(new Type(dataType.STRUCT), line, column);
        this.id = id;
        this.subStructId = subStructId;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        if (subStructId != null) {
            return new StructType(id, type, subStructId);
        }

        StructType structType = new StructType(id, type);
        return structType;
    }
}
