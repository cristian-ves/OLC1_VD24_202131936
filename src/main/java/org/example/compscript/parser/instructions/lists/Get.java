package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Get extends ListMethod {

    public Get(String id, Instruction exp, int line, int column) {
        super(exp, id, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        var list = getList(symbolsTable);
        if (list instanceof CompError) return list;

        var pos = getPosition(tree, symbolsTable);
        if(pos instanceof CompError) return pos;

        try{
            return ((LinkedList<Object>)((Symbol_) list).getValue()).get((int) pos);
        }catch (IndexOutOfBoundsException e){
            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: index: " + (int) pos + ", size: " + ((LinkedList<Object>)((Symbol_) list).getValue()).size(),
                    line,
                    column
            );
        }

    }
}
