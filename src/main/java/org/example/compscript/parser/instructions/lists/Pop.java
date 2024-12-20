package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.Symbol_;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;

import java.util.LinkedList;

public class Pop extends ListMethod{

    public Pop(String id, int line, int column) {
        super(id, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        var list = getList(symbolsTable);
        if (list instanceof CompError) return list;

        LinkedList<Object> listRes = (LinkedList<Object>)((Symbol_) list).getValue();
        int indexLastItem = listRes.size() - 1;

        if (indexLastItem < 0)
            return new CompError(
                    ErrorType.RUNTIME,
                    "Invalid argument, expected a positive number, provided: " + indexLastItem,
                    line,
                    column
            );

        try{
            return listRes.remove(indexLastItem);
        }catch (IndexOutOfBoundsException e){
            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: index: " + indexLastItem + ", size: " + listRes.size(),
                    line,
                    column
            );
        }

    }
}
