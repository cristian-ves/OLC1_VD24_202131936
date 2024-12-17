package org.example.compscript.parser.symbol;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;

import java.util.LinkedList;

public class Tree {

    private LinkedList<Instruction> instructions;
    private String console;
    private LinkedList<CompError> errors;

    public Tree(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
        console = "";
        this.errors = new LinkedList<>();
    }

    public LinkedList<Instruction> getInstructions() {
        return instructions;
    }

    public String getConsole() {
        return console;
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
}
