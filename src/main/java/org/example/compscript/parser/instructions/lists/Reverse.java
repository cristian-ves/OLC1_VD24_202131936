package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.symbol.Symbol_;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;

import java.util.LinkedList;

public class Reverse extends ListMethod{

    public Reverse(String id, int line, int column) {
        super(id, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var list = getList(symbolsTable);
        if (list instanceof CompError) return list;

        LinkedList<Object> listRes = (LinkedList<Object>)((Symbol_) list).getValue();
        ((Symbol_) list).setValue(listRes.reversed());

        return null;
    }
}
