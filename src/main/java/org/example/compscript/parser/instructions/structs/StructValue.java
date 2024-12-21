package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class StructValue extends Instruction {

    private String id;
    private Instruction valueExp;

    public StructValue(String id, Instruction valueExp, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.valueExp = valueExp;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var valueResult = valueExp.interpret(tree, symbolsTable);
        if(valueResult instanceof CompError) return valueResult;

        LinkedList<Object> list = new LinkedList<>();
        list.add(id);
        list.add(valueResult);

        this.type.setType(valueExp.type.getType());

        return list;
    }
}
