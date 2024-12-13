package org.example.compscript.parser.expresions.variables;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Access extends Instruction {
    private String id;

    public Access(String id, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var value = symbolsTable.getVariable(id);
        if(value == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "the variable " + id + " hasn't been declared yet",
                    this.line,
                    this.column
            );

        this.type.setType(value.getType().getType());
        return value.getValue();

    }
}
