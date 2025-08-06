package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.response.IResponse;

public class MarketDetailResponse implements IResponse {
    private static final long serialVersionUID = -7967464466983773487L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70643ch;
    private String symbol;
    private KlineInfo tick;

    public String getCh() {
        return this.f70643ch;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public KlineInfo getTick() {
        return this.tick;
    }

    public boolean isSuccess() {
        return this.tick != null;
    }

    public void setCh(String str) {
        this.f70643ch = str;
        this.symbol = str.split("\\.")[1];
    }

    public void setTick(KlineInfo klineInfo) {
        this.tick = klineInfo;
    }
}
