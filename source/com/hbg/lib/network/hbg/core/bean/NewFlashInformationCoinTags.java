package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class NewFlashInformationCoinTags implements Serializable {
    private static final long serialVersionUID = 3857927613239218301L;
    private String coin;
    private String percent = "--";
    private String symbol;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCoin() {
        return this.coin;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    public void setPercent(String str) {
        this.percent = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
