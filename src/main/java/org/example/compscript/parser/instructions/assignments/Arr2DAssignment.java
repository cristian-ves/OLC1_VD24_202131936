package org.example.compscript.parser.instructions.assignments;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class Arr2DAssignment extends Instruction {

    private String id;
    private Instruction pos1Exp;
    private Instruction pos2Exp;
    private Instruction newValue;

    public Arr2DAssignment(String id, Instruction pos1Exp, Instruction pos2Exp, Instruction newValue, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.pos1Exp = pos1Exp;
        this.pos2Exp = pos2Exp;
        this.newValue = newValue;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var resultNewValue = this.newValue.interpret(tree, symbolsTable);
        if(resultNewValue instanceof CompError) return resultNewValue;

        var resPos1 = this.pos1Exp.interpret(tree, symbolsTable);
        if(resPos1 instanceof CompError) return resPos1;

        var resPos2 = this.pos1Exp.interpret(tree, symbolsTable);
        if(resPos2 instanceof CompError) return resPos2;

        if(pos1Exp.type.getType() != dataType.WHOLE || pos2Exp.type.getType() != dataType.WHOLE) {
            String wrongType = (pos1Exp.type.getType() != dataType.WHOLE) ?
                    pos1Exp.type.getType().getValue() :
                    pos2Exp.type.getType().getValue();
            return new CompError(
                    ErrorType.SEMANTIC,
                    "position must be integer, type provided: " + wrongType,
                    line,
                    column
            );
        }

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

            return ((LinkedList<Object>) ((LinkedList<Object>) arr.getValue())
                    .get((int) resPos1))
                    .set((int) resPos2, resultNewValue);

        } catch (IndexOutOfBoundsException e){

            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: Index: " + resPos1 + ", Size: " + ((LinkedList<Object>) arr.getValue()).size(),
                    line,
                    column
            );

        }
    }
}
