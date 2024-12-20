package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Set extends ListMethod{

    public Set(String id, Instruction posExp, Instruction newValue, int line, int column) {
        super(id, posExp, newValue, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        var list = getList(symbolsTable);
        if (list instanceof CompError) return list;

        var pos = getPosition(tree, symbolsTable);
        if(pos instanceof CompError) return pos;

        var newValueRes = getExpRes(tree, symbolsTable);
        if(newValueRes instanceof CompError) return newValueRes;

        ((LinkedList<Object>)((Symbol_) list).getValue()).set((int) pos, newValueRes);
        return null;

    }
}
