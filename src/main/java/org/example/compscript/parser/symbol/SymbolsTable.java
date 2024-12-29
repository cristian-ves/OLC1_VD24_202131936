package org.example.compscript.parser.symbol;

import java.util.HashMap;

public class SymbolsTable {

    private HashMap<String, Symbol_> currentTable;
    private SymbolsTable prevTable;
    private STableType type;
    private boolean isBroken;
    private boolean isUncontinued;

    public SymbolsTable(STableType type) {
        this.currentTable = new HashMap<>();
        this.type = type;
        this.isBroken = false;
    }

    public SymbolsTable(SymbolsTable prevTable, STableType type) {
        this.prevTable = prevTable;
        this.currentTable = new HashMap<>();
        this.type = type;
        this.isBroken = false;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public boolean isUncontinued() {
        return isUncontinued;
    }

    public STableType getType() {
        return type;
    }

    public HashMap<String, Symbol_> getCurrentTable() {
        return currentTable;
    }

    public SymbolsTable getPrevTable() {
        return prevTable;
    }

    public void setCurrentTable(HashMap<String, Symbol_> currentTable) {
        this.currentTable = currentTable;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void setUncontinued(boolean uncontinued) {
        isUncontinued = uncontinued;
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

        for(SymbolsTable i = this; i != null; i = i.getPrevTable()){

            Symbol_ searchedSymbol = (Symbol_) i.currentTable.get(id.toLowerCase());
            if(searchedSymbol != null)
                return searchedSymbol;
        }

        return null;

    }

    public Symbol_ getVariablePrevTable(String id) {
        for(SymbolsTable i = this.prevTable; i != null; i = i.getPrevTable()){
            Symbol_ searchedSymbol = (Symbol_) i.currentTable.get(id.toLowerCase());
            if (searchedSymbol != null) return searchedSymbol;
        }

        return null;
    }

    public int putVariable (String id, Symbol_ symbol) {
        Symbol_ searchedSymbol = getVariable(id);

        if(searchedSymbol == null) return 0; // variable not declared

        if(!searchedSymbol.isMutable()) return 1; // variable not mutable 'const'

        symbol.setMutable(true);

        if(searchedSymbol.getType().getType() == symbol.getType().getType()) {
            searchedSymbol.setValue(symbol.getValue());
            return 2; // success
        }

        return 3; // types not matching

    }

}
