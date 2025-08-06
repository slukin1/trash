package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LegalQueryData implements Serializable {
    public static final int TYPE_AVAIL = 0;
    public static final int TYPE_BORROW = 2;
    public static final int TYPE_FROZEN = 1;
    private static final long serialVersionUID = 6361154256339381705L;
    private String borrow;
    private int coinId;
    private String coinName;
    private String frozen;
    @SerializedName("total")
    private String total;

    public String getAvaialAble() {
        return this.total;
    }

    public String getBorrow() {
        return this.borrow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getFrozen() {
        return this.frozen;
    }

    public void setAvaialAble(String str) {
        this.total = str;
    }

    public void setBorrow(String str) {
        this.borrow = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setFrozen(String str) {
        this.frozen = str;
    }
}
