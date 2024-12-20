package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.LinkedList;

public class Get extends Instruction {

    private String id;
    private Instruction exp;

    public Get(String id, Instruction exp, int line, int column) {
        super(new Type(dataType.VOID), column, line);
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

        if (this.exp.type.getType() != dataType.WHOLE)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "List.get() requires an int. provided: "  + this.exp.type.getType().getValue(),
                    line,
                    column
            );

        this.type.setType(list.getType().getType());

        try {
            return ((LinkedList<Object>)list.getValue()).get((int) res);
        } catch (IndexOutOfBoundsException e) {
            return new CompError(
                    ErrorType.RUNTIME,
                    "Index out of bounds: Index: " + (int) res + ", Size: " + ((LinkedList<Object>)list.getValue()).size(),
                    line,
                    column
            );
        }
    }
}
