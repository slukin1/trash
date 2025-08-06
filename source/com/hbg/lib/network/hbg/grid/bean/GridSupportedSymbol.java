package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class GridSupportedSymbol implements Serializable {
    private ArrayList<String> symbols;

    public boolean canEqual(Object obj) {
        return obj instanceof GridSupportedSymbol;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridSupportedSymbol)) {
            return false;
        }
        GridSupportedSymbol gridSupportedSymbol = (GridSupportedSymbol) obj;
        if (!gridSupportedSymbol.canEqual(this)) {
            return false;
        }
        ArrayList<String> symbols2 = getSymbols();
        ArrayList<String> symbols3 = gridSupportedSymbol.getSymbols();
        return symbols2 != null ? symbols2.equals(symbols3) : symbols3 == null;
    }

    public ArrayList<String> getSymbols() {
        return this.symbols;
    }

    public int hashCode() {
        ArrayList<String> symbols2 = getSymbols();
        return 59 + (symbols2 == null ? 43 : symbols2.hashCode());
    }

    public void setSymbols(ArrayList<String> arrayList) {
        this.symbols = arrayList;
    }

    public String toString() {
        return "GridSupportedSymbol(symbols=" + getSymbols() + ")";
    }
}
