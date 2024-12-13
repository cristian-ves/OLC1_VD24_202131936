package org.example.compscript.parser.symbol;

public class Symbol_ {

    private Type type;
    private String id;
    private Object value;
    private boolean isMutable;

    public Symbol_(Type type, String id) {
        this.type = type;
        this.id = id;
    }

    public Symbol_(Type type, String id, Object value) {
        this.type = type;
        this.id = id;
        this.value = value;
    }

    public Symbol_(Type type, String id, Object value, boolean isMutable) {
        this.type = type;
        this.id = id;
        this.value = value;
        this.isMutable = isMutable;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public boolean isMutable() {
        return isMutable;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setMutable(boolean isMutable) {
        this.isMutable = isMutable;
    }

    @Override
    public String toString() {
        return "Symbol_{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", value=" + value +
                ", isMutable=" + isMutable +
                '}';
    }
}
