package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Remove extends ListMethod {

    public Remove(String id, Instruction posExp, int line, int column) {
        super(id, posExp, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        var list = getList(symbolsTable);
        if(list instanceof CompError) return list;

        var resPos = getPosition(tree, symbolsTable);
        if(resPos instanceof CompError) return resPos;

        ((LinkedList<Object>) ((Symbol_) list).getValue()).remove((int) resPos);
        return null;

    }
}
