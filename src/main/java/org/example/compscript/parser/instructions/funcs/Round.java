package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Round extends Instruction {

    private Instruction expression;

    public Round(Instruction expression, int line, int column) {
        super(new Type(dataType.WHOLE), line, column);
        this.expression = expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var expRes = expression.interpret(tree, symbolsTable);
        if(expRes instanceof CompError) return expRes;

        if(expression.type.getType() != dataType.WHOLE && expression.type.getType() != dataType.DOUBLE)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The Round function requires an int or double, provided: " + expression.type.getType().getValue(),
                    line,
                    column
            );

        int result = (int) Math.round((double) expRes);
        return result;
    }
}
