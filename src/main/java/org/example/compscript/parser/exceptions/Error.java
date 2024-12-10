package org.example.compscript.parser.exceptions;

public class Error {
    private String type;
    private String desc;
    private int line;
    private int column;

    public Error(String type, String desc, int line, int column) {
        this.type = type;
        this.desc = desc;
        this.line = line;
        this.column = column;
    }
}
