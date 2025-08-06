package com.huobi.staring.bean;

import java.io.Serializable;

public class CustomSaveResult implements Serializable {
    private int priceId;

    public boolean canEqual(Object obj) {
        return obj instanceof CustomSaveResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomSaveResult)) {
            return false;
        }
        CustomSaveResult customSaveResult = (CustomSaveResult) obj;
        return customSaveResult.canEqual(this) && getPriceId() == customSaveResult.getPriceId();
    }

    public int getPriceId() {
        return this.priceId;
    }

    public int hashCode() {
        return 59 + getPriceId();
    }

    public void setPriceId(int i11) {
        this.priceId = i11;
    }

    public String toString() {
        return "CustomSaveResult(priceId=" + getPriceId() + ")";
    }
}
