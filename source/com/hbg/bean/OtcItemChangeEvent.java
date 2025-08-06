package com.hbg.bean;

import java.io.Serializable;

public class OtcItemChangeEvent implements Serializable {
    private int otcCoinId;

    public int getOtcCoinId() {
        return this.otcCoinId;
    }

    public void setOtcCoinId(int i11) {
        this.otcCoinId = i11;
    }
}
