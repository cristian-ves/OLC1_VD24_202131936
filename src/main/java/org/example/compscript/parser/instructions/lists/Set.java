package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Set extends Instruction {

    private String id;
    private Instruction posExp;
    private Instruction newValue;

    public Set(String id, Instruction posExp, Instruction newValue, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.posExp = posExp;
        this.newValue = newValue;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        Symbol_ list = symbolsTable.getVariable(id);
        if(list == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The variable " + id + " hasn't been declared yet.",
                    line,
                    column
            );

        var resPos = posExp.interpret(tree, symbolsTable);
        if(resPos instanceof CompError) return resPos;
        if(posExp.type.getType() != dataType.WHOLE)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid argument for position: type provided: " + posExp.type.getType().getValue() + ", required: int",
                    line,
                    column
            );

        var resNewValue = newValue.interpret(tree, symbolsTable);
        if(resNewValue instanceof CompError) return resNewValue;
        if(newValue.type.getType() != list.getType().getType())
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid argument for new value: type provided: " + newValue.type.getType().getValue() + ", required: " + list.getType().getType().getValue(),
                    line,
                    column
            );

        ((LinkedList<Object>) list.getValue()).set((int) resPos, resNewValue);
        return null;

    }
}
