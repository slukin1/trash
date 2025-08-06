package com.huobi.finance.bean;

import java.io.Serializable;

public class CurrencyAddrWithTag implements Serializable {
    private static final long serialVersionUID = 4237888485238412454L;
    private String address;
    private String tag;

    public String getAddress() {
        return this.address;
    }

    public String getTag() {
        return this.tag;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
