package org.example.compscript.parser.expresions.variables;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class Arr2DAccess extends Instruction {

    private String id;
    private Instruction position1Expression;
    private Instruction position2Expression;

    public Arr2DAccess(String id, Instruction position1Expression, Instruction position2Expression, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.position1Expression = position1Expression;
        this.position2Expression = position2Expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var arr = symbolsTable.getVariable(id);
        if(arr == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "the arr " + id + " hasn't been declared yet",
                    this.line,
                    this.column
            );

        this.type.setType(arr.getType().getType());

        var position1 = position1Expression.interpret(tree, symbolsTable);
        var position2 = position2Expression.interpret(tree, symbolsTable);
        if(position1Expression.type.getType() != dataType.WHOLE || position2Expression.type.getType() != dataType.WHOLE) {
            String wrongType = (position1Expression.type.getType() != dataType.WHOLE) ?
                    position1Expression.type.getType().getValue() :
                    position2Expression.type.getType().getValue();
            return new CompError(
                    ErrorType.SEMANTIC,
                    "To access an array value you must provide an int type for the position, not a " + wrongType,
                    line,
                    column
            );
        }

        LinkedList<Object> arr2;
        try {
            arr2 =(LinkedList<Object>) ((LinkedList<Object>) arr.getValue()).get((int) position1);
        } catch (IndexOutOfBoundsException e) {
            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: Index: " + position1 + ", Size: " + ((LinkedList<Object>) arr.getValue()).size(),
                    line,
                    column
            );
        }

        try{
            return arr2.get((int) position2);
        }catch (IndexOutOfBoundsException e){
            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: Index: " + position2 + ", Size: " + arr2.size(),
                    line,
                    column
            );
        }
    }
}
