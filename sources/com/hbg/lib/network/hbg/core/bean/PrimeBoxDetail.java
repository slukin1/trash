package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class PrimeBoxDetail implements Serializable {
    private long cardEndTime;
    private long endTime;
    private String exchangeUrl;

    /* renamed from: id  reason: collision with root package name */
    private long f70264id;
    private String name;
    private String rule;
    private long serverTime;
    private long startTime;
    private int status;

    public long getCardEndTime() {
        return this.cardEndTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getExchangeUrl() {
        return this.exchangeUrl;
    }

    public long getId() {
        return this.f70264id;
    }

    public String getName() {
        return this.name;
    }

    public String getRule() {
        return this.rule;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setCardEndTime(long j11) {
        this.cardEndTime = j11;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setExchangeUrl(String str) {
        this.exchangeUrl = str;
    }

    public void setId(long j11) {
        this.f70264id = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRule(String str) {
        this.rule = str;
    }

    public void setServerTime(long j11) {
        this.serverTime = j11;
    }

    public void setStartTime(long j11) {
        this.startTime = j11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }
}
