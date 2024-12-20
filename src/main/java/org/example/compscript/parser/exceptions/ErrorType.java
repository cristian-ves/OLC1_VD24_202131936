package org.example.compscript.parser.exceptions;

public enum ErrorType {
    SEMANTIC("Semantic"),
    LEXICAL("Lexical"),
    SINTACTICR("Recovered sintactic"),
    SINTACTICU("Unrecoverable sintactic"),
    RUNTIME("Runtime");

    private final String value;

    ErrorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
