package com.huobi.contract.entity;

import java.io.Serializable;

public class WebContractSymbolData implements Serializable {
    private static final long serialVersionUID = -5815174354402043535L;
    private String currentContract;

    public WebContractSymbolData(String str) {
        setCurrentContract(str);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof WebContractSymbolData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebContractSymbolData)) {
            return false;
        }
        WebContractSymbolData webContractSymbolData = (WebContractSymbolData) obj;
        if (!webContractSymbolData.canEqual(this)) {
            return false;
        }
        String currentContract2 = getCurrentContract();
        String currentContract3 = webContractSymbolData.getCurrentContract();
        return currentContract2 != null ? currentContract2.equals(currentContract3) : currentContract3 == null;
    }

    public String getCurrentContract() {
        return this.currentContract;
    }

    public int hashCode() {
        String currentContract2 = getCurrentContract();
        return 59 + (currentContract2 == null ? 43 : currentContract2.hashCode());
    }

    public void setCurrentContract(String str) {
        this.currentContract = str;
    }

    public String toString() {
        return "WebContractSymbolData(currentContract=" + getCurrentContract() + ")";
    }
}
