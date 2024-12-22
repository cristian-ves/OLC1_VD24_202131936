package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

public class StructInstanceIns extends Instruction {

    private String id;
    private boolean isMutable;
    private String type;
    private LinkedList<Instruction> values;

    public StructInstanceIns(String isMutable, String id, String type, LinkedList<Instruction> values, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.isMutable = Boolean.parseBoolean(isMutable);
        this.type = type;
        this.values = values;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        Symbol_ struct = symbolsTable.getVariable(type);
        if(struct == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Struct " + id + " is not declared yet.",
                    line,
                    column
            );

        HashMap<String, LinkedList<Object>> map = new HashMap<>();
        StructInstance instance = new StructInstance(type, map);
        Symbol_ instaceSymbol = new Symbol_(new Type(dataType.STRUCT), id, instance, isMutable);

        HashMap structTypes = (HashMap) struct.getValue();

        for (Instruction valueIns : values) {
            var res = valueIns.interpret(tree, symbolsTable);
            if (res instanceof CompError) return res;

            LinkedList<Object> valueResult = (LinkedList<Object>) res;
            String fieldName = (String) valueResult.get(0);
            Object fieldValue = valueResult.get(1);
            if(fieldValue instanceof CompError) return fieldValue;

            //verify that field it's part of the struct
            if(!structTypes.containsKey(fieldName))
                return new CompError(
                        ErrorType.SEMANTIC,
                        type + " struct doesn't have a field name for: " + fieldName,
                        line,
                        column
                );

            if(((Type) structTypes.get(fieldName)).getType() != valueIns.type.getType())
                return new CompError(
                        ErrorType.SEMANTIC,
                        fieldName + " must be of type " + ((Type) structTypes.get(fieldName)).getType().getValue() + ", provided: " + valueIns.type.getType().getValue(),
                        line,
                        column
                );

            LinkedList<Object> fieldProps = new LinkedList<>();
            fieldProps.add(fieldValue);
            fieldProps.add(valueIns.type);
            map.put(fieldName, fieldProps);
        }

        symbolsTable.setVariable(instaceSymbol);

        return null;
    }
}
