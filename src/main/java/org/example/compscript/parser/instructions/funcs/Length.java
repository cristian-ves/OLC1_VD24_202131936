package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.expresions.variables.Access;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.LinkedList;

public class Length extends Instruction {

    private Instruction expression;
    private String id;

    public Length(Instruction expression, int line, int column) {
        super(new Type(dataType.WHOLE), line, column);
        this.expression = expression;
    }

    public Length(String id, int line, int column) {
        super(new Type(dataType.WHOLE), line, column);
        this.id = id;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        var expRes = expression.interpret(tree, symbolsTable);
        if (expRes instanceof CompError) return expRes;

        if (expRes instanceof LinkedList<?> list) return list.size();

        if (expRes instanceof String string) return string.length();


        return new CompError(
                ErrorType.SEMANTIC,
                "The Length function can only be used for strings, lists and arrays",
                line,
                column
        );

    }
}
