package com.hbg.lib.network.pro.socket.bean;

import java.io.Serializable;
import java.util.Objects;
import lombok.NonNull;

public class KlineInfo implements Comparable<KlineInfo>, Serializable, Cloneable {
    private static final long serialVersionUID = 5947303349079107482L;
    private double amount;
    private double bollHigh;
    private double bollLow;
    private double bollMid;
    private double close;
    private long count;
    private double dea;
    private double dif;
    public Serializable extraInfoBean;
    private double high;

    /* renamed from: id  reason: collision with root package name */
    private long f70630id;
    private double low;
    private double macd;
    private double open;

    /* renamed from: ts  reason: collision with root package name */
    private long f70631ts;
    private double vol;

    public KlineInfo() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f70630id == ((KlineInfo) obj).f70630id) {
            return true;
        }
        return false;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBollHigh() {
        return this.bollHigh;
    }

    public double getBollLow() {
        return this.bollLow;
    }

    public double getBollMid() {
        return this.bollMid;
    }

    public double getChange() {
        return this.close - this.open;
    }

    public double getChangeRatio() {
        double d11 = this.close;
        double d12 = this.open;
        return (d11 - d12) / d12;
    }

    public double getClose() {
        return this.close;
    }

    public long getCount() {
        return this.count;
    }

    public double getDea() {
        return this.dea;
    }

    public double getDif() {
        return this.dif;
    }

    public Serializable getExtraInfoBean() {
        return this.extraInfoBean;
    }

    public double getHigh() {
        return this.high;
    }

    public long getId() {
        return this.f70630id;
    }

    public double getLow() {
        return this.low;
    }

    public double getMacd() {
        return this.macd;
    }

    public double getOpen() {
        return this.open;
    }

    public long getTime() {
        return this.f70630id;
    }

    public long getTimeMs() {
        return this.f70630id * 1000;
    }

    public long getTs() {
        return this.f70631ts;
    }

    public double getValue() {
        return this.close;
    }

    public double getVol() {
        return this.vol;
    }

    public void setAmount(double d11) {
        this.amount = d11;
    }

    public void setBollHigh(double d11) {
        this.bollHigh = d11;
    }

    public void setBollLow(double d11) {
        this.bollLow = d11;
    }

    public void setBollMid(double d11) {
        this.bollMid = d11;
    }

    public void setClose(double d11) {
        this.close = d11;
    }

    public void setCount(long j11) {
        this.count = j11;
    }

    public void setDea(double d11) {
        this.dea = d11;
    }

    public void setDif(double d11) {
        this.dif = d11;
    }

    public void setExtraInfoBean(Serializable serializable) {
        this.extraInfoBean = serializable;
    }

    public void setHigh(double d11) {
        this.high = d11;
    }

    public void setId(long j11) {
        this.f70630id = j11;
    }

    public void setLow(double d11) {
        this.low = d11;
    }

    public void setMacd(double d11) {
        this.macd = d11;
    }

    public void setOpen(double d11) {
        this.open = d11;
    }

    public void setTs(long j11) {
        this.f70631ts = j11;
    }

    public void setVol(double d11) {
        this.vol = d11;
    }

    public String toString() {
        return "KlineInfo(id=" + getId() + ", ts=" + getTs() + ", high=" + getHigh() + ", low=" + getLow() + ", open=" + getOpen() + ", close=" + getClose() + ", amount=" + getAmount() + ", count=" + getCount() + ", vol=" + getVol() + ", bollHigh=" + getBollHigh() + ", bollMid=" + getBollMid() + ", bollLow=" + getBollLow() + ", dif=" + getDif() + ", dea=" + getDea() + ", macd=" + getMacd() + ", extraInfoBean=" + getExtraInfoBean() + ")";
    }

    public KlineInfo(long j11, long j12, double d11, double d12, double d13, double d14, double d15, long j13, double d16, double d17, double d18, double d19, double d21, double d22, double d23, Serializable serializable) {
        this.f70630id = j11;
        this.f70631ts = j12;
        this.high = d11;
        this.low = d12;
        this.open = d13;
        this.close = d14;
        this.amount = d15;
        this.count = j13;
        this.vol = d16;
        this.bollHigh = d17;
        this.bollMid = d18;
        this.bollLow = d19;
        this.dif = d21;
        this.dea = d22;
        this.macd = d23;
        this.extraInfoBean = serializable;
    }

    public KlineInfo clone() {
        return new KlineInfo(this.f70630id, this.f70631ts, this.high, this.low, this.open, this.close, this.amount, this.count, this.vol, this.bollHigh, this.bollMid, this.bollLow, this.dif, this.dea, this.macd, (Serializable) null);
    }

    public int compareTo(@NonNull KlineInfo klineInfo) {
        Objects.requireNonNull(klineInfo, "another is marked @NonNull but is null");
        long j11 = this.f70630id;
        long j12 = klineInfo.f70630id;
        if (j11 > j12) {
            return 1;
        }
        return j11 < j12 ? -1 : 0;
    }
}
