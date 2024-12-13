package org.example.compscript.parser.exceptions;

public class CompError {
    private ErrorType type;
    private String desc;
    private int line;
    private int column;

    public CompError(ErrorType type, String desc, int line, int column) {
        this.type = type;
        this.desc = desc;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "CompError{" +
                "type=" + type.getValue() +
                ", desc='" + desc + '\'' +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
