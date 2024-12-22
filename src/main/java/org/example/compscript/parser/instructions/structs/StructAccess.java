package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

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
        Symbol_ structSymbol = symbolsTable.getVariable(structId);
        if (structSymbol == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    structId + " variable hasn't been declared yet",
                    line,
                    column
            );

        if(structSymbol.getType().getType() != dataType.STRUCT)
            return new CompError(
                    ErrorType.SEMANTIC,
                    structId + " is not a struct instance",
                    column,
                    line
            );

        StructInstance instance = (StructInstance) structSymbol.getValue();
        HashMap<String, LinkedList<Object>> instanceMap = instance.getMap();
        LinkedList<Object> fieldProps = instanceMap.get(fieldId);
        var fieldValue = fieldProps.get(0);
        if (fieldValue == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    fieldId + " is not a " + structId + " field.",
                    line,
                    column
            );

        this.type.setType(((Type) fieldProps.get(1)).getType());

        return fieldValue;
    }
}
