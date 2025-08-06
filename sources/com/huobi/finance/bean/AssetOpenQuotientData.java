package com.huobi.finance.bean;

import java.io.Serializable;

public class AssetOpenQuotientData implements Serializable {
    private int usableQuotient = 100;

    public int getUsableQuotient() {
        return this.usableQuotient;
    }

    public void setUsableQuotient(int i11) {
        this.usableQuotient = i11;
    }
}
