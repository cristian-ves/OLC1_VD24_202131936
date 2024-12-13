package org.example.compscript.parser.symbol;

import java.util.HashMap;

public class SymbolsTable {

    private HashMap<String, Symbol_> currentTable;
    private String name;

    public SymbolsTable() {
        this.currentTable = new HashMap<>();
        this.name = "";
    }

    public HashMap<String, Symbol_> getCurrentTable() {
        return currentTable;
    }

    public String getName() {
        return name;
    }

    public void setCurrentTable(HashMap<String, Symbol_> currentTable) {
        this.currentTable = currentTable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setVariable (Symbol_ symbol) {
        Symbol_ searchedSymbol = (Symbol_) this.currentTable.get(symbol.getId().toLowerCase());

        if (searchedSymbol == null) {
            this.currentTable.put(symbol.getId().toLowerCase(), symbol);
            System.out.println(symbol.toString());
             return true;
        }

        return false;
    }
}
