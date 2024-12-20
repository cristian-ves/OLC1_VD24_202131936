package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Push extends ListMethod {

    public Push(String id, Instruction exp, int line, int column) {
        super(id, exp, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var list = getList(symbolsTable);
        if (list instanceof CompError) return list;

        var newValueRes = getExpRes(tree, symbolsTable);
        if(newValueRes instanceof CompError) return newValueRes;

        ((LinkedList<Object>)((Symbol_) list).getValue()).add(newValueRes);
        return null;


    }
}
