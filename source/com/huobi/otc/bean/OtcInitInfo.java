package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcInitInfo implements Serializable {
    private String clientName;

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }
}
