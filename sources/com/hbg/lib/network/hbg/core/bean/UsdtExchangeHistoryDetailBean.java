package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UsdtExchangeHistoryDetailBean implements Serializable {
    private String currency;
    private Long time;
    private String usdtVolume;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof UsdtExchangeHistoryDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UsdtExchangeHistoryDetailBean)) {
            return false;
        }
        UsdtExchangeHistoryDetailBean usdtExchangeHistoryDetailBean = (UsdtExchangeHistoryDetailBean) obj;
        if (!usdtExchangeHistoryDetailBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = usdtExchangeHistoryDetailBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String usdtVolume2 = getUsdtVolume();
        String usdtVolume3 = usdtExchangeHistoryDetailBean.getUsdtVolume();
        if (usdtVolume2 != null ? !usdtVolume2.equals(usdtVolume3) : usdtVolume3 != null) {
            return false;
        }
        Long time2 = getTime();
        Long time3 = usdtExchangeHistoryDetailBean.getTime();
        if (time2 != null ? !time2.equals(time3) : time3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = usdtExchangeHistoryDetailBean.getVolume();
        return volume2 != null ? volume2.equals(volume3) : volume3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Long getTime() {
        return this.time;
    }

    public String getUsdtVolume() {
        return this.usdtVolume;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String usdtVolume2 = getUsdtVolume();
        int hashCode2 = ((hashCode + 59) * 59) + (usdtVolume2 == null ? 43 : usdtVolume2.hashCode());
        Long time2 = getTime();
        int hashCode3 = (hashCode2 * 59) + (time2 == null ? 43 : time2.hashCode());
        String volume2 = getVolume();
        int i12 = hashCode3 * 59;
        if (volume2 != null) {
            i11 = volume2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setTime(Long l11) {
        this.time = l11;
    }

    public void setUsdtVolume(String str) {
        this.usdtVolume = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "UsdtExchangeHistoryDetailBean(currency=" + getCurrency() + ", usdtVolume=" + getUsdtVolume() + ", time=" + getTime() + ", volume=" + getVolume() + ")";
    }
}
