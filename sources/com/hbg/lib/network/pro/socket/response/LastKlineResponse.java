package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.response.IResponse;

public class LastKlineResponse implements IResponse {
    private static final long serialVersionUID = 6065255411247338981L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70639ch;
    private String period;
    private String symbol;
    private KlineInfo tick;

    public String getCh() {
        return this.f70639ch;
    }

    public String getPeriod() {
        return this.period;
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
        this.f70639ch = str;
        String[] split = str.split("\\.");
        this.symbol = split[1];
        this.period = split[3];
    }

    public void setTick(KlineInfo klineInfo) {
        this.tick = klineInfo;
    }
}
