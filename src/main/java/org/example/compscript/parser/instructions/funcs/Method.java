package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

import java.util.HashMap;
import java.util.LinkedList;

public class Method extends Instruction {

    public String id;
    public LinkedList<HashMap> parameters;
    public LinkedList<Instruction> instructions;

    public Method(Type type, String id, LinkedList<HashMap> parameters, LinkedList<Instruction> instructions, int line, int column) {
        super(type, line, column);
        this.id = id;
        this.instructions = instructions;
        this.parameters = parameters == null ? new LinkedList<>() : parameters;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        for (Instruction instruction : instructions) {
            if (instruction == null) {
                continue;
            }
            var result = instruction.interpret(tree, symbolsTable);
            if (result instanceof CompError) return result;
            if (symbolsTable.isReturned()) {
                var expReturned = symbolsTable.getExpReturned();
                if (expReturned == null) {
                    if (type.getType() != dataType.VOID)
                        return new CompError(
                                ErrorType.SEMANTIC,
                                "Void returns can only be used in methods and not in functions",
                                line,
                                column
                        );
                    return expReturned;
                }

                var expRes = expReturned.interpret(tree, symbolsTable);
                if (expRes instanceof CompError) return expRes;

                if (expReturned.type.getType() != this.type.getType())
                    return new CompError(
                            ErrorType.SEMANTIC,
                            "Incorrect return statement type: required: " + type.getType().getValue() + ", provided: " + expReturned.type.getType().getValue(),
                            line,
                            column
                    );
                LinkedList<Object> values = new LinkedList<>();
                values.add(expRes);
                values.add(type);
                return values;
            }
        }
        if (this.type.getType() != dataType.VOID)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Functions must return something",
                    line,
                    column
            );
        return null;
    }
}
