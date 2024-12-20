package org.example.compscript.parser.instructions.assignments;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class ArrAssignment extends Instruction {

    private String id;
    private Instruction positionExp;
    private Instruction newValue;

    public ArrAssignment(String id, Instruction positionExp, Instruction newValue, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.positionExp = positionExp;
        this.newValue = newValue;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var resultNewValue = this.newValue.interpret(tree, symbolsTable);
        if(resultNewValue instanceof CompError) return resultNewValue;

        var resPos = this.positionExp.interpret(tree, symbolsTable);
        if(resPos instanceof CompError) return resPos;

        if(positionExp.type.getType() != dataType.WHOLE)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The position type for the array must be an integer and not: " + positionExp.type.getType().getValue(),
                    line,
                    column
            );

        var arr = symbolsTable.getVariable(this.id);

        if(arr == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The variable " + id + " hasn't been declared",
                    this.line,
                    this.column
            );

        if(!arr.isMutable())
            return new CompError(
                ErrorType.SEMANTIC,
                "The const variable " + id + " is immutable",
                this.line,
                this.column
            );

        if(arr.getType().getType() != newValue.type.getType())
            return new CompError(
                ErrorType.SEMANTIC,
                "The assignment types are not matching, expecting: " +
                        symbolsTable.getVariable(id).getType().getType().getValue() + ", provided: " + newValue.type.getType().getValue(),
                this.line,
                this.column
            );

        try{

           return ((LinkedList<Object>) arr.getValue()).set((int) resPos, resultNewValue);

        } catch (IndexOutOfBoundsException e){

            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: Index: " + resPos + ", Size: " + ((LinkedList<Object>) arr.getValue()).size(),
                    line,
                    column
            );

        }

    }
}
