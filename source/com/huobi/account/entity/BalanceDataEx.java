package com.huobi.account.entity;

import java.io.Serializable;

public class BalanceDataEx implements Serializable {
    private static final long serialVersionUID = -2864210040406643914L;
    private BalanceQueryData data;
    private String netAsset;

    public BalanceDataEx(String str, BalanceQueryData balanceQueryData) {
        this.netAsset = str;
        this.data = balanceQueryData;
    }

    public BalanceQueryData getData() {
        return this.data;
    }

    public String getNetAsset() {
        return this.netAsset;
    }
}
