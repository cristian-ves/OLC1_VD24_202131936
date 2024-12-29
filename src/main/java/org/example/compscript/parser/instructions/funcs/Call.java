package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

public class Call extends Instruction {

    private String funcId;
    private LinkedList<HashMap> arguments;

    public Call(String funcId, LinkedList<HashMap> arguments, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.funcId = funcId;
        this.arguments = arguments == null ? new LinkedList<>() : arguments;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var search = tree.getFunction(funcId);
        if (search == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The function " + funcId + " hasn't been declared yet.",
                    line,
                    column
            );

        if (search instanceof Method method) {

            var newTable = new SymbolsTable(symbolsTable, STableType.METHOD);

            for (int i = 0; i < method.parameters.size(); i++) {
                var id = (String) method.parameters.get(i).get("id");
                var type = (Type) method.parameters.get(i).get("type");
                var exp = (Instruction) method.parameters.get(i).get("exp");

                Object valExp = null;

                if (exp != null) { // expression validation
                    valExp = exp.interpret(tree, symbolsTable);
                    if (valExp instanceof CompError) return valExp;
                    if (type.getType() != exp.type.getType())
                        return new CompError(
                                ErrorType.SEMANTIC,
                                "Parameter types not matching: provided: " + exp.type.getType().getValue() + ", required: " + type.getType().getValue(),
                                line,
                                column
                        );
                }

                if (!newTable.setVariable(new Symbol_(type, id, valExp))) {
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "This variable already exists in the environment.",
                            line,
                            column
                    );
                }

            }

            for (int i = 0; i < arguments.size(); i++) {
                String parameterId = (String) arguments.get(i).get("id");
                var variable = newTable.getVariable(parameterId);
                if(variable == null)
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "The parameter " + parameterId + " doesn't exist.",
                            line,
                            column
                    );

                var value = (Instruction) arguments.get(i).get("exp");
                var valueRes = value.interpret(tree, symbolsTable);
                if(valueRes instanceof CompError) return valueRes;

                if(value.type.getType() != variable.getType().getType())
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "argument type not matching: provided: " + value.type.getType().getValue() + ", required: " + variable.getType().getType().getValue(),
                            line,
                            column
                    );
                variable.setValue(valueRes);
            }

            for(int i = 0; i < method.parameters.size(); i++) {
                var id = (String) method.parameters.get(i).get("id");
                var res = newTable.getVariable(id);
                if(res == null)
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "Parameter " + id + " not declared.",
                            line,
                            column
                    );

                if(res.getValue() == null)
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "Parameter " + res.getId() + " doesn't have a value declared.",
                            line,
                            column
                    );
            }

            var res = method.interpret(tree, newTable);
            if (res instanceof CompError) return (CompError) res;

            //TODO: return expression
        }

        return null;

    }
}
