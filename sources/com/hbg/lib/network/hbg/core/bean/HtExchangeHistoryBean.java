package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HtExchangeHistoryBean implements Serializable {
    private String currency;
    private String htFee;
    private String htVolume;

    /* renamed from: id  reason: collision with root package name */
    private long f70243id;
    private long time;

    public boolean canEqual(Object obj) {
        return obj instanceof HtExchangeHistoryBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HtExchangeHistoryBean)) {
            return false;
        }
        HtExchangeHistoryBean htExchangeHistoryBean = (HtExchangeHistoryBean) obj;
        if (!htExchangeHistoryBean.canEqual(this) || getId() != htExchangeHistoryBean.getId() || getTime() != htExchangeHistoryBean.getTime()) {
            return false;
        }
        String htFee2 = getHtFee();
        String htFee3 = htExchangeHistoryBean.getHtFee();
        if (htFee2 != null ? !htFee2.equals(htFee3) : htFee3 != null) {
            return false;
        }
        String htVolume2 = getHtVolume();
        String htVolume3 = htExchangeHistoryBean.getHtVolume();
        if (htVolume2 != null ? !htVolume2.equals(htVolume3) : htVolume3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = htExchangeHistoryBean.getCurrency();
        return currency2 != null ? currency2.equals(currency3) : currency3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getHtFee() {
        return this.htFee;
    }

    public String getHtVolume() {
        return this.htVolume;
    }

    public long getId() {
        return this.f70243id;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        long id2 = getId();
        long time2 = getTime();
        String htFee2 = getHtFee();
        int i11 = (((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) ((time2 >>> 32) ^ time2))) * 59;
        int i12 = 43;
        int hashCode = i11 + (htFee2 == null ? 43 : htFee2.hashCode());
        String htVolume2 = getHtVolume();
        int hashCode2 = (hashCode * 59) + (htVolume2 == null ? 43 : htVolume2.hashCode());
        String currency2 = getCurrency();
        int i13 = hashCode2 * 59;
        if (currency2 != null) {
            i12 = currency2.hashCode();
        }
        return i13 + i12;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setHtFee(String str) {
        this.htFee = str;
    }

    public void setHtVolume(String str) {
        this.htVolume = str;
    }

    public void setId(long j11) {
        this.f70243id = j11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "HtExchangeHistoryBean(id=" + getId() + ", time=" + getTime() + ", htFee=" + getHtFee() + ", htVolume=" + getHtVolume() + ", currency=" + getCurrency() + ")";
    }
}
