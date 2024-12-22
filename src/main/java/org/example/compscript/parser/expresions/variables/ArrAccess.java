package org.example.compscript.parser.expresions.variables;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class ArrAccess extends Instruction {

    private String id;
    private Instruction positionExpression;

    public ArrAccess(String id, Instruction positionExpresion, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.positionExpression = positionExpresion;
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

        var position = positionExpression.interpret(tree, symbolsTable);
        if(positionExpression.type.getType() != dataType.WHOLE)
            return new CompError(
                ErrorType.SEMANTIC,
                "To access an array value you must provide an int type, not a " + positionExpression.type.getType().getValue(),
                line,
                column
            );

        try {
            return ((LinkedList<Object>) arr.getValue()).get((int) position);
        } catch (IndexOutOfBoundsException e) {
            return new CompError(
                ErrorType.RUNTIME,
                    "Index out of bounds: Index: " + position + ", Size: " + ((LinkedList<Object>) arr.getValue()).size(),
                    line,
                    column
            );
        }

        // add type to returned value to make arithmetic operators work

    }
}
