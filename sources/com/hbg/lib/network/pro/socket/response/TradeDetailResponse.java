package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.retrofit.response.IResponse;

public class TradeDetailResponse implements IResponse {
    private static final long serialVersionUID = 6085936768730839892L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70651ch;

    /* renamed from: id  reason: collision with root package name */
    private long f70652id;
    private String symbol;
    private MarketInfoTradesTick tick;

    /* renamed from: ts  reason: collision with root package name */
    private long f70653ts;

    public String getCh() {
        return this.f70651ch;
    }

    public long getId() {
        return this.f70652id;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public MarketInfoTradesTick getTick() {
        return this.tick;
    }

    public long getTs() {
        return this.f70653ts;
    }

    public boolean isSuccess() {
        return this.tick != null;
    }

    public void setCh(String str) {
        this.f70651ch = str;
        this.symbol = str.split("\\.")[1];
    }

    public void setId(long j11) {
        this.f70652id = j11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTick(MarketInfoTradesTick marketInfoTradesTick) {
        this.tick = marketInfoTradesTick;
    }

    public void setTs(long j11) {
        this.f70653ts = j11;
    }
}
