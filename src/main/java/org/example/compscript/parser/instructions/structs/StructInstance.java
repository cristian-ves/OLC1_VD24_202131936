package org.example.compscript.parser.instructions.structs;

import java.util.HashMap;
import java.util.LinkedList;

public class StructInstance {

    private String type;
    private HashMap <String, LinkedList<Object>> map;

    public StructInstance(String type, HashMap<String, LinkedList<Object>> map) {
        this.type = type;
        this.map = map;
    }

    public HashMap<String, LinkedList<Object>> getMap() {
        return map;
    }

    public String getType() {
        return type;
    }
}
