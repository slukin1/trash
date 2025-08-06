package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CurrencyRateBean implements Serializable {
    private static final long serialVersionUID = 7319688689566124047L;
    private long dataTime;
    private String name;
    private BigDecimal rate;
    private long time;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyRateBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyRateBean)) {
            return false;
        }
        CurrencyRateBean currencyRateBean = (CurrencyRateBean) obj;
        if (!currencyRateBean.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = currencyRateBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        BigDecimal rate2 = getRate();
        BigDecimal rate3 = currencyRateBean.getRate();
        if (rate2 != null ? rate2.equals(rate3) : rate3 == null) {
            return getTime() == currencyRateBean.getTime() && getDataTime() == currencyRateBean.getDataTime();
        }
        return false;
    }

    public long getDataTime() {
        return this.dataTime;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        BigDecimal rate2 = getRate();
        int i12 = (hashCode + 59) * 59;
        if (rate2 != null) {
            i11 = rate2.hashCode();
        }
        long time2 = getTime();
        int i13 = ((i12 + i11) * 59) + ((int) (time2 ^ (time2 >>> 32)));
        long dataTime2 = getDataTime();
        return (i13 * 59) + ((int) ((dataTime2 >>> 32) ^ dataTime2));
    }

    public void setDataTime(long j11) {
        this.dataTime = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRate(BigDecimal bigDecimal) {
        this.rate = bigDecimal;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "CurrencyRateBean(name=" + getName() + ", rate=" + getRate() + ", time=" + getTime() + ", dataTime=" + getDataTime() + ")";
    }
}
