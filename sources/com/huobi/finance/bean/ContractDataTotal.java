package com.huobi.finance.bean;

public class ContractDataTotal extends BaseAssetTotal {
    public boolean canEqual(Object obj) {
        return obj instanceof ContractDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ContractDataTotal) && ((ContractDataTotal) obj).canEqual(this) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "ContractDataTotal()";
    }
}
