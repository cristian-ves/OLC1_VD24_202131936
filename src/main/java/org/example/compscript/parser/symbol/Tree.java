package org.example.compscript.parser.symbol;

import java_cup.runtime.Symbol;
import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.instructions.funcs.Method;
import org.example.compscript.parser.instructions.structs.StructDeclaration;

import java.util.LinkedList;
import java.util.function.Function;

public class Tree {

    private LinkedList<Instruction> instructions;
    private String console;
    private LinkedList<CompError> errors;
    private SymbolsTable globalTable;
    private LinkedList<Instruction> functions;
    private LinkedList<Instruction> structs;

    public Tree(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
        console = "";
        this.errors = new LinkedList<>();
        this.functions = new LinkedList<>();
        this.structs = new LinkedList<>();
    }

    public LinkedList<Instruction> getFunctions() {
        return functions;
    }

    public void setFunctions(LinkedList<Instruction> functions) {
        this.functions = functions;
    }

    public void addFunction(Instruction function) {
        functions.add(function);
    }

    public void addStruct(Instruction struct) {
        structs.add(struct);
    }

    public Instruction getFunction(String id) {
        for (Instruction instruction : functions) {
            if (instruction instanceof Method method) {
                if(method.id.equalsIgnoreCase(id)) {
                    return instruction;
                }
            }
        }
        return null;
    }

    public Instruction getStruct(String id){
        for (Instruction instruction : structs) {
            if(instruction instanceof StructDeclaration struct) {
                if(struct.getId().equalsIgnoreCase(id)) {
                    return instruction;
                }
            }
        }
        return null;
    }

    public LinkedList<Instruction> getInstructions() {
        return instructions;
    }

    public String getConsole() {
        return console;
    }

    public SymbolsTable getGlobalTable() {
        return globalTable;
    }

    public void setInstructions(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public void print(String value){
        this.console += value + "\n";
    }

    public void addError(CompError error) {
        this.errors.add(error);
    }

    public LinkedList<CompError> getErrors() {
        return errors;
    }

    public void setGlobalTable(SymbolsTable globalTable) {
        this.globalTable = globalTable;
    }
}
