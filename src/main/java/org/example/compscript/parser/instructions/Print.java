package org.example.compscript.parser.instructions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;
import org.example.compscript.parser.symbol.SymbolsTable;

public class Print extends Instruction {

    private Instruction expression;

    public Print(Instruction expression, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.expression = expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable table) {
        var value = this.expression.interpret(tree, table);
        if (value instanceof CompError) {
            return value;
        }
        tree.print(value.toString());
        return null;
    }


}
