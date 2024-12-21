package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

public class StructInstance extends Instruction {

    private String id;
    private boolean isMutable;
    private String type;
    private LinkedList<Instruction> values;

    public StructInstance(String isMutable, String id, String type, LinkedList<Instruction> values, int line, int column) {
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

        HashMap<String, Object> map = new HashMap<>();
        Symbol_ structInstance = new Symbol_(new Type(dataType.VOID), id, map, isMutable);

        for (Instruction valueIns : values) {
            var res = valueIns.interpret(tree, symbolsTable);
            if ( res instanceof CompError) return  res;

            LinkedList<Object> valueResult = (LinkedList<Object>) res;
            String valueId = (String) valueResult.get(0);
            Object value = valueResult.get(1);
            if(value instanceof CompError) return value;

            HashMap structTypes = (HashMap) struct.getValue();
            if(((Type) structTypes.get(valueId)).getType() != valueIns.type.getType())
                return new CompError(
                        ErrorType.SEMANTIC,
                        valueId + " must be of type " + ((Type) structTypes.get(valueId)).getType().getValue() + ", provided: " + valueIns.type.getType().getValue(),
                        line,
                        column
                );

            map.put(valueId, value);
        }

        symbolsTable.setVariable(structInstance);

        return null;
    }
}
