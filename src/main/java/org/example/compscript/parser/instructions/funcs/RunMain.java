package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

import java.util.HashMap;
import java.util.LinkedList;

public class RunMain extends Instruction {

    private String id;
    private LinkedList<HashMap> parameters;

    public RunMain(String id, LinkedList<HashMap> parameters, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        if (parameters != null) this.parameters = parameters;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        var search = tree.getFunction(id);
        if (search == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The function " + id + " hasn't been declared yet.",
                    line,
                    column
            );

        if (search instanceof Method method) {

            var newTable = new SymbolsTable(tree.getGlobalTable(), tree.getGlobalTable().getType());

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

            for (int i = 0; i < parameters.size(); i++) {
                String parameterId = (String) parameters.get(i).get("id");
                var variable = newTable.getVariable(parameterId);
                if(variable == null)
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "The parameter " + parameterId + " doesn't exist.",
                            line,
                            column
                    );

                var value = (Instruction) parameters.get(i).get("exp");
                var valueRes = value.interpret(tree, newTable);
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
        }

        return null;

//let i: int;
//
//void func(int: a = 10, int: b) {
//    let i : string = "adios";
//    let j : string = "pajas";
//    console.log("run main jijij" + i + " " + j);
//    console.log(a);
//    console.log(b);
//    printHalf(a=a,b=b);
//}
//
//run_main func(b=2, a=50);
//
//int printHalf(int:a, int:b){
//    const sum : int = a + b;
//    const result : double = sum / 2;
//    console.log(result);
//}

    }
}
