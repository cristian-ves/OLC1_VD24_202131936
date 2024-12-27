package org.example.compscript.parser.instructions.funcs;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;

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
        this.parameters = parameters;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {
        for (Instruction instruction : instructions) {
            if(instruction == null) {
                continue;
            }
            var result = instruction.interpret(tree, symbolsTable);
            if(result instanceof CompError) return result;
        }
        return null;
    }
}
