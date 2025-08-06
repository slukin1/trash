package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.retrofit.response.IResponse;

public class MarketDepthResponse implements IResponse {
    private static final long serialVersionUID = 4401425801927068580L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70640ch;

    /* renamed from: id  reason: collision with root package name */
    private long f70641id;
    private String symbol;
    private TradeBuySellData tick;

    /* renamed from: ts  reason: collision with root package name */
    private long f70642ts;

    public String getCh() {
        return this.f70640ch;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeBuySellData getTick() {
        return this.tick;
    }

    public boolean isSuccess() {
        return this.tick != null;
    }

    public void setCh(String str) {
        this.f70640ch = str;
        this.symbol = str.split("\\.")[1];
    }

    public void setTick(TradeBuySellData tradeBuySellData) {
        this.tick = tradeBuySellData;
    }

    public String toString() {
        return "MarketDepthResponse{id=" + this.f70641id + ", ts=" + this.f70642ts + ", ch='" + this.f70640ch + '\'' + ", symbol='" + this.symbol + '\'' + ", tick=" + this.tick + '}';
    }
}
