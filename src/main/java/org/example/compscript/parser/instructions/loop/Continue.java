package org.example.compscript.parser.instructions.loop;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

public class Continue extends Instruction {

    public Continue(int line, int column) {
        super(new Type(dataType.VOID), line, column);
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        SymbolsTable loopTable = getUncontinuedEnvironment(symbolsTable);

        if(loopTable == null) return new CompError(
                ErrorType.SEMANTIC,
                "The sentence continue can only be used inside of a loop.",
                this.line,
                this.column
        );

        loopTable.setUncontinued(true);

        return null;

    }

    public SymbolsTable getUncontinuedEnvironment(SymbolsTable symbolsTable) {
        for(var i=symbolsTable; i!= null; i = i.getPrevTable()){
            if(i.getType() == STableType.LOOP){
                return i;
            }
        }
        return null;
    }
}
