package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

public class StructAssignment extends Instruction {

    private String instanceId;
    private String fieldName;
    private Instruction newValueExp;

    public StructAssignment(String instanceId, String fieldName, Instruction newValueExp, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.instanceId = instanceId;
        this.fieldName = fieldName;
        this.newValueExp = newValueExp;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        Symbol_ instanceSym = symbolsTable.getVariable(instanceId);
        if (instanceSym == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    instanceId + " variable hasn't been declared yet",
                    line,
                    column
            );

        var newValueRes = newValueExp.interpret(tree, symbolsTable);
        if(newValueRes instanceof CompError) return newValueRes;

        StructInstance instance = (StructInstance) instanceSym.getValue();
        HashMap<String, LinkedList<Object>> instanceMap = instance.getMap();
        //validate field exists
        if(!instanceMap.containsKey(fieldName))
            return new CompError(
                ErrorType.SEMANTIC,
                fieldName + " field does not exist for struct variable: " + instanceId,
                line,
                column
            );
        LinkedList<Object> instanceValues = instanceMap.get(fieldName);

        // validate new value is field's type
        if(newValueExp.type.getType() != ((Type) instanceValues.get(1)).getType())
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid type assignment: required: " + ((Type) instanceValues.get(1)).getType().getValue() + ", provided: " + newValueExp.type.getType(),
                    line,
                    column
            );
        instanceValues.set(0, newValueRes);

        return null;
    }
}
