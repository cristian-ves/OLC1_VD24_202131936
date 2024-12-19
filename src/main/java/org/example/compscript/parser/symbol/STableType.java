package org.example.compscript.parser.symbol;

public enum STableType {

    MAIN("main"),
    LOOP("loop"),
    IF("if"),
    MATCH("match"),;

    private final String value;

    STableType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
