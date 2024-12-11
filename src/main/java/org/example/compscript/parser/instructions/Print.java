package org.example.compscript.parser.instructions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;
import org.example.compscript.parser.symbol.SymbolsTable;

public class Print extends Instruction {

    private Instruction expresion;

    public Print(Instruction expresion, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.expresion = expresion;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable table) {
        var value = this.expresion.interpret(tree, table);
        if (value instanceof Error) {
            return value;
        }
        System.out.println(value.toString());
        tree.print(value.toString());
        return null;
    }


}
