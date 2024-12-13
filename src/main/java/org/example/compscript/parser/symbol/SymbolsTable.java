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
             return true;
        }

        return false;
    }

    public Symbol_ getVariable (String id) {
        Symbol_ searchedSymbol = (Symbol_) this.currentTable.get(id.toLowerCase());

        if(searchedSymbol != null) {
            return searchedSymbol;
        }

        return null;
    }

    public int putVariable (String id, Symbol_ symbol) {
        Symbol_ searchedSymbol = (Symbol_) this.currentTable.get(id.toLowerCase());

        if(searchedSymbol == null) return 0; // variable not declared

        if(!searchedSymbol.isMutable()) return 1; // variable not mutable 'const'

        symbol.setMutable(true);

        if(searchedSymbol.getType().getType() == symbol.getType().getType()) {
            this.currentTable.put(id.toLowerCase(), symbol);
            return 2; // success
        }

        return 3; // types not matching

    }

}
