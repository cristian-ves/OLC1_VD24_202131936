package org.example.compscript.parser.expresions.operators.logic;

import org.example.compscript.parser.abstract_.Instruction;
import org.example.compscript.parser.exceptions.CompError;
import org.example.compscript.parser.exceptions.ErrorType;
import org.example.compscript.parser.symbol.SymbolsTable;
import org.example.compscript.parser.symbol.Tree;
import org.example.compscript.parser.symbol.Type;
import org.example.compscript.parser.symbol.dataType;

public class Or extends Instruction {

    private Instruction leftExp;
    private Instruction rightExp;

    public Or(Instruction leftExp, Instruction rightExp, int line, int column) {
        super(new Type(dataType.BOOLEAN), line, column);
        this.leftExp = leftExp;
        this.rightExp = rightExp;
    }

    @Override
    public Object interpret(Tree tree, SymbolsTable symbolsTable) {

        String desc = "Invalid logic operation ||";

        var res1 = this.leftExp.interpret(tree, symbolsTable);
        if(res1 instanceof Error) {
            return res1;
        }

        var res2 = this.rightExp.interpret(tree, symbolsTable);
        if(res2 instanceof Error) {
            return res2;
        }

        System.out.println(res2);
        System.out.println(res2.getClass());
        System.out.println(res1);
        System.out.println(res1.getClass());

        var type1 = this.leftExp.type.getType();
        var type2 = this.rightExp.type.getType();
        System.out.println(type1 +" " +type2);

        if (type1==dataType.BOOLEAN && type2==dataType.BOOLEAN) return (boolean) res1 || (boolean) res2;
        return new CompError(ErrorType.SEMANTIC, desc, this.line, this.column);

    }

}