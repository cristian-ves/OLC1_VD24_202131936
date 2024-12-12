package org.example.compscript.parser.expresions.operators.logic;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Not extends Instruction {

    private Instruction expression;

    public Not(Instruction expression, int line, int column) {
        super(new Type(dataType.BOOLEAN), line, column);
        this.expression = expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var result = this.expression.interpret(tree, symbolsTable);
        if (result instanceof CompError) {
            return result;
        }

        return (this.expression.type.getType() == dataType.BOOLEAN) ?
                !((boolean) result) :
                new CompError(ErrorType.SEMANTIC, "Invalid 'not' expression", this.line, this.column);

    }

}