package com.hbg.lib.network.pro.socket.bean;

import java.io.Serializable;
import java.util.List;

public class TradeBuySellData implements Serializable {
    private static final long serialVersionUID = -7008794204607729448L;
    private List<Double[]> asks;
    private List<Double[]> bids;

    /* renamed from: id  reason: collision with root package name */
    private long f70634id;

    /* renamed from: ts  reason: collision with root package name */
    private long f70635ts;

    public List<Double[]> getAsks() {
        return this.asks;
    }

    public List<Double[]> getBids() {
        return this.bids;
    }

    public long getId() {
        return this.f70634id;
    }

    public long getTs() {
        return this.f70635ts;
    }

    public void setAsks(List<Double[]> list) {
        this.asks = list;
    }

    public void setBids(List<Double[]> list) {
        this.bids = list;
    }

    public void setId(long j11) {
        this.f70634id = j11;
    }

    public void setTs(long j11) {
        this.f70635ts = j11;
    }

    public String toString() {
        return "TradeBuySellData{id=" + this.f70634id + ", ts=" + this.f70635ts + ", bids=" + this.bids + ", asks=" + this.asks + '}';
    }
}
