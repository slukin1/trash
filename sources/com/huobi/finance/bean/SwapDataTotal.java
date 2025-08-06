package com.huobi.finance.bean;

public class SwapDataTotal extends BaseAssetTotal {
    public boolean canEqual(Object obj) {
        return obj instanceof SwapDataTotal;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SwapDataTotal) && ((SwapDataTotal) obj).canEqual(this) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "SwapDataTotal()";
    }
}
