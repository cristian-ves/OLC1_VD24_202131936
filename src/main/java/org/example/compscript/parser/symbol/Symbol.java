package org.example.compscript.parser.symbol;

public class Symbol {

    private Type type;
    private String id;
    private Object value;

    public Symbol(Type type, String id) {
        this.type = type;
        this.id = id;
    }

    public Symbol(Type type, String id, Object value) {
        this.type = type;
        this.id = id;
        this.value = value;
    }

}
