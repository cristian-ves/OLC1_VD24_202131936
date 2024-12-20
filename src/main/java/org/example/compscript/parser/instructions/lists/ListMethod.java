package org.example.compscript.parser.instructions.lists;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.*;

public abstract class ListMethod extends Instruction {

    protected String id;
    protected Instruction posExp;
    protected Instruction valueExp;
    protected Symbol_ list;

    public ListMethod(String id, Instruction valueExp, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.valueExp = valueExp;
    }

    public ListMethod(Instruction posExp, String id, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.posExp = posExp;
    }

    public ListMethod(String id, Instruction posExp, Instruction valueExp, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
        this.posExp = posExp;
        this.valueExp = valueExp;
    }

    public ListMethod(String id, int line, int column) {
        super(new Type(dataType.VOID), line, column);
        this.id = id;
    }

    public Object getList(SymbolsTable symbolsTable) {
        list = symbolsTable.getVariable(this.id);
        if(list == null)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "The list " + id + " hasn't been declared yet",
                    line,
                    column
            );
        return list;
    }

    public Object getPosition(Tree tree, SymbolsTable symbolsTable) {
        var res = this.posExp.interpret(tree, symbolsTable);
        if (res instanceof CompError) return res;

        if (this.posExp.type.getType() != dataType.WHOLE)
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid argument for position: type provided: " + posExp.type.getType().getValue() + ", required: int",
                    line,
                    column
            );

        return res;
    }

    public Object getExpRes(Tree tree, SymbolsTable symbolsTable){
        var res = valueExp.interpret(tree, symbolsTable);
        if(res instanceof CompError) return res;
        if(valueExp.type.getType() != list.getType().getType())
            return new CompError(
                    ErrorType.SEMANTIC,
                    "Invalid argument type: provided: " + valueExp.type.getType().getValue() + ", required: " + list.getType().getType().getValue(),
                    line,
                    column
            );
        return res;
    }


}
