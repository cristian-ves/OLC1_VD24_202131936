package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.Symbol_;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;

import java.util.LinkedList;

public class ListDeclaration extends Instruction {

    private String id;
    private boolean isMutable;

    public ListDeclaration(String isMutable, String id, Type type, int line, int column) {
        super(type, line, column);
        this.isMutable = Boolean.parseBoolean(isMutable);
        this.id = id;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        if (!isMutable)
            return new CompError(
                ErrorType.SINTACTICR,
                "Lists must be declared using let",
                line,
                column
            );

        Symbol_ list = new Symbol_(this.type, this.id, new LinkedList<>(), true);
        symbolsTable.setVariable(list);
        return null;
    }
}
