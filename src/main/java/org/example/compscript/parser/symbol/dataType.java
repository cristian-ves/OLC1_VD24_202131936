package org.example.compscript.parser.symbol;

public enum dataType {
    WHOLE("int"),
    DOUBLE("double"),
    BOOLEAN("bool"),
    CHAR("char"),
    STRING("string"),
    VOID("void");

    private final String value;

    dataType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
