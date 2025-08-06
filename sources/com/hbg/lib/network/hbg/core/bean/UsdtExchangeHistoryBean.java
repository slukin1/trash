package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UsdtExchangeHistoryBean implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private long f70271id;
    private long time;
    private String usdtFee;
    private String usdtVolume;

    public boolean canEqual(Object obj) {
        return obj instanceof UsdtExchangeHistoryBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UsdtExchangeHistoryBean)) {
            return false;
        }
        UsdtExchangeHistoryBean usdtExchangeHistoryBean = (UsdtExchangeHistoryBean) obj;
        if (!usdtExchangeHistoryBean.canEqual(this) || getId() != usdtExchangeHistoryBean.getId() || getTime() != usdtExchangeHistoryBean.getTime()) {
            return false;
        }
        String usdtFee2 = getUsdtFee();
        String usdtFee3 = usdtExchangeHistoryBean.getUsdtFee();
        if (usdtFee2 != null ? !usdtFee2.equals(usdtFee3) : usdtFee3 != null) {
            return false;
        }
        String usdtVolume2 = getUsdtVolume();
        String usdtVolume3 = usdtExchangeHistoryBean.getUsdtVolume();
        return usdtVolume2 != null ? usdtVolume2.equals(usdtVolume3) : usdtVolume3 == null;
    }

    public long getId() {
        return this.f70271id;
    }

    public long getTime() {
        return this.time;
    }

    public String getUsdtFee() {
        return this.usdtFee;
    }

    public String getUsdtVolume() {
        return this.usdtVolume;
    }

    public int hashCode() {
        long id2 = getId();
        long time2 = getTime();
        String usdtFee2 = getUsdtFee();
        int i11 = (((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) ((time2 >>> 32) ^ time2))) * 59;
        int i12 = 43;
        int hashCode = i11 + (usdtFee2 == null ? 43 : usdtFee2.hashCode());
        String usdtVolume2 = getUsdtVolume();
        int i13 = hashCode * 59;
        if (usdtVolume2 != null) {
            i12 = usdtVolume2.hashCode();
        }
        return i13 + i12;
    }

    public void setId(long j11) {
        this.f70271id = j11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public void setUsdtFee(String str) {
        this.usdtFee = str;
    }

    public void setUsdtVolume(String str) {
        this.usdtVolume = str;
    }

    public String toString() {
        return "UsdtExchangeHistoryBean(id=" + getId() + ", time=" + getTime() + ", usdtFee=" + getUsdtFee() + ", usdtVolume=" + getUsdtVolume() + ")";
    }
}
