package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HtExchangeHistoryDetailBean implements Serializable {
    private String currency;
    private String htVolume;
    private Long time;
    private String unit;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof HtExchangeHistoryDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HtExchangeHistoryDetailBean)) {
            return false;
        }
        HtExchangeHistoryDetailBean htExchangeHistoryDetailBean = (HtExchangeHistoryDetailBean) obj;
        if (!htExchangeHistoryDetailBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = htExchangeHistoryDetailBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String htVolume2 = getHtVolume();
        String htVolume3 = htExchangeHistoryDetailBean.getHtVolume();
        if (htVolume2 != null ? !htVolume2.equals(htVolume3) : htVolume3 != null) {
            return false;
        }
        Long time2 = getTime();
        Long time3 = htExchangeHistoryDetailBean.getTime();
        if (time2 != null ? !time2.equals(time3) : time3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = htExchangeHistoryDetailBean.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String unit2 = getUnit();
        String unit3 = htExchangeHistoryDetailBean.getUnit();
        return unit2 != null ? unit2.equals(unit3) : unit3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getHtVolume() {
        return this.htVolume;
    }

    public Long getTime() {
        return this.time;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String htVolume2 = getHtVolume();
        int hashCode2 = ((hashCode + 59) * 59) + (htVolume2 == null ? 43 : htVolume2.hashCode());
        Long time2 = getTime();
        int hashCode3 = (hashCode2 * 59) + (time2 == null ? 43 : time2.hashCode());
        String volume2 = getVolume();
        int hashCode4 = (hashCode3 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String unit2 = getUnit();
        int i12 = hashCode4 * 59;
        if (unit2 != null) {
            i11 = unit2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setHtVolume(String str) {
        this.htVolume = str;
    }

    public void setTime(Long l11) {
        this.time = l11;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "HtExchangeHistoryDetailBean(currency=" + getCurrency() + ", htVolume=" + getHtVolume() + ", time=" + getTime() + ", volume=" + getVolume() + ", unit=" + getUnit() + ")";
    }
}
