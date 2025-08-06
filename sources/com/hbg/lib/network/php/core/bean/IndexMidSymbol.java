package com.hbg.lib.network.php.core.bean;

import java.io.Serializable;

public class IndexMidSymbol implements Serializable {
    private String symbol;
    private String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IndexMidSymbol indexMidSymbol = (IndexMidSymbol) obj;
        String str = this.symbol;
        if (str == null ? indexMidSymbol.symbol != null : !str.equals(indexMidSymbol.symbol)) {
            return false;
        }
        String str2 = this.type;
        String str3 = indexMidSymbol.type;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.symbol;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
