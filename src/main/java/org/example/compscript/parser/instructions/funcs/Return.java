package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

public class Return extends Instruction {

    private Instruction exp;

    public Return(Instruction exp, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.exp = exp;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        SymbolsTable methodEnvironment = getReturnedEnvironment(symbolsTable);

        if(methodEnvironment == null) return new CompError(
                ErrorType.SEMANTIC,
                "The sentence return can only be used inside of a method.",
                this.line,
                this.column
        );

        methodEnvironment.setReturned(true);
        methodEnvironment.setExpReturned(exp);

        return null;
    }

    public SymbolsTable getReturnedEnvironment(SymbolsTable symbolsTable) {
        for(var i=symbolsTable; i!= null; i = i.getPrevTable()){
            if(i.getType() == STableType.METHOD){
                return i;
            }
        }
        return null;
    }
}
