package org.example.compscript.parser.expresions;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

public class UnitaryNegation extends Instruction {

    private Instruction expression;

    public UnitaryNegation(Instruction expression, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.expression = expression;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var result = this.expression.interpret(tree, symbolsTable);
        if (result instanceof CompError) {
            return result;
        }

        switch (this.expression.type.getType()) {
            case WHOLE ->  {
                this.type.setType(dataType.WHOLE);
                return -(int) result;
            }
            case DOUBLE -> {
                this.type.setType(dataType.DOUBLE);
                return -(double) result;
            }
            default -> {
                return new CompError(ErrorType.SEMANTIC, "Invalid unitary negation", this.line, this.column);
            }
        }
    }
}
