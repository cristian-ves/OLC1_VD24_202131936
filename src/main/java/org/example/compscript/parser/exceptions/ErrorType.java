package org.example.compscript.parser.exceptions;

public enum ErrorType {
    SEMANTIC("Semantico");

    private final String value;

    ErrorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
