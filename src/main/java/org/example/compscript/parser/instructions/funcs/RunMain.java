package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.instructions.declarations.Declaration;
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

            if (parameters != null) {
                if (method.parameters != null) {

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
                        //TODO: rest

                    }
                }
            }

            var res = method.interpret(tree, newTable);
            if (res instanceof CompError) return (CompError) res;
        }

        return null;

    }
}
