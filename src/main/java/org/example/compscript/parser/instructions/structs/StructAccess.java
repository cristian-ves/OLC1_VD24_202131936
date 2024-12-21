package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;

public class StructAccess extends Instruction {

    private String structId;
    private String fieldId;

    public StructAccess(String structId, String fieldId, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.structId = structId;
        this.fieldId = fieldId;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        Symbol_ struct = symbolsTable.getVariable(structId);
        if (struct == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    structId + " variable hasn't been declared yet",
                    line,
                    column
            );

        HashMap<String, Object> structMap = (HashMap<String, Object>) struct.getValue();
        var field = structMap.get(fieldId);
        if (field == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    fieldId + " is not a " + structId + " field.",
                    line,
                    column
            );

        return field;
    }
}
