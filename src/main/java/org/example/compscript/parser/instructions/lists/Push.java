package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Push extends Instruction {

    private String id;
    private Instruction exp;

    public Push(String id, Instruction exp, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.exp = exp;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        Symbol_ list = symbolsTable.getVariable(this.id);

        if(list == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The list " + id + " hasn't been declared yet",
                    line,
                    column
            );

        var res = this.exp.interpret(tree, symbolsTable);
        if (res instanceof CompError) return res;

        if (this.exp.type.getType() != list.getType().getType())
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Incorrect type in push: required: " + list.getType().getType().getValue() + ", provided: " + this.exp.type.getType().getValue(),
                    line,
                    column
            );

        ((LinkedList<Object>)list.getValue()).add(res);
        return null;

    }
}
