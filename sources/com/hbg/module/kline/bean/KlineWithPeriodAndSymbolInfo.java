package com.hbg.module.kline.bean;

import com.hbg.lib.network.pro.socket.bean.KlineInfo;

public class KlineWithPeriodAndSymbolInfo extends KlineInfo {
    private static final long serialVersionUID = 6501536747050442745L;
    private String period;
    private String symbol;

    public String getPeriod() {
        return this.period;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setPeriod(String str) {
        this.period = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }
}
