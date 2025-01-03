package org.example.compscript.parser.instructions.structs;

import org.example.compscript.parser.symbol.Type;

public class StructType {

    private String id;
    private Type type;
    private String subStructId;

    public StructType(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    public StructType(String id, Type type, String subStructId) {
        this.id = id;
        this.type = type;
        this.subStructId = subStructId;
    }

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
