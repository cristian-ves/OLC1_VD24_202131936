package org.example.compscript.parser.exceptions;

public class Error {
    private ErrorType type;
    private String desc;
    private int line;
    private int column;

    public Error(ErrorType type, String desc, int line, int column) {
        this.type = type;
        this.desc = desc;
        this.line = line;
        this.column = column;
    }
}
