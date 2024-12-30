package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

public class StructDeclaration extends Instruction {

    private String id;
    private LinkedList<Instruction> types;
    private HashMap<String, Type> typesMap;

    public StructDeclaration(String id, LinkedList<Instruction> types, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.types = types;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        typesMap = new HashMap<String, Type>();

        for (Instruction typeIns : types) {
            StructType type = (StructType) typeIns.interpret(tree, symbolsTable);
            typesMap.put(type.getId(), type.getType());
        }

        Symbol_ typesSymbol = new Symbol_(new Type(dataType.VOID), this.id, typesMap);
        symbolsTable.setVariable(typesSymbol);
        return null;

    }

    public String getId() {
        return id;
    }
}
