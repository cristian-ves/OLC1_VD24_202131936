package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class ToString extends Instruction {

    private Instruction expression;

    public ToString(Instruction expression, int line, int column) {
        super(new Type(dataType.STRING), line, column);
        this.expression = expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var expRes = expression.interpret(tree, symbolsTable);
        if(expRes instanceof CompError) return expRes;

        if (expRes instanceof Integer integer) return String.valueOf(integer);

        if (expRes instanceof Double doubleValue) return String.valueOf(doubleValue);

        if(expRes instanceof Character character) return String.valueOf(character);

        if(expRes instanceof Boolean bool) return String.valueOf(bool);

        // struct to text

        return new CompError(
                ErrorType.SEMANTIC,
                "The length function can only work with types: integer, double, bool, char and struct.",
                line,
                column
        );
    }

}
