package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.socket.bean.EtpNav;
import com.hbg.lib.network.retrofit.response.IResponse;

public class MarketEtpNavResponse implements IResponse {
    private static final long serialVersionUID = -7967464466983773487L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70644ch;
    private String symbol;
    private EtpNav tick;

    public String getCh() {
        return this.f70644ch;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public EtpNav getTick() {
        return this.tick;
    }

    public boolean isSuccess() {
        return this.tick != null;
    }

    public void setCh(String str) {
        this.f70644ch = str;
        this.symbol = str.split("\\.")[1];
    }

    public void setTick(EtpNav etpNav) {
        this.tick = etpNav;
    }
}
