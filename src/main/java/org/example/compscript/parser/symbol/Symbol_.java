package org.example.compscript.parser.symbol;

public class Symbol_ {

    private Type type;
    private String id;
    private Object value;

    public Symbol_(Type type, String id) {
        this.type = type;
        this.id = id;
    }

    public Symbol_(Type type, String id, Object value) {
        this.type = type;
        this.id = id;
        this.value = value;
    }

}
