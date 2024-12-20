package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Remove extends ListMethod {

    public Remove(Instruction posExp, String id, int line, int column) {
        super(posExp, id, line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        var list = getList(symbolsTable);
        if(list instanceof CompError) return list;

        var resPos = getPosition(tree, symbolsTable);
        if(resPos instanceof CompError) return resPos;

        try{
            return ((LinkedList<Object>) ((Symbol_) list).getValue()).remove((int) resPos);
        }catch (IndexOutOfBoundsException e){
            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: index: " + (int) resPos + ", size: " + ((LinkedList<Object>)((Symbol_) list).getValue()).size(),
                    line,
                    column
            );
        }



    }
}
