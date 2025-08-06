package com.huobi.litere.bean;

import java.io.Serializable;

public class LiteExchangeBean implements Serializable {
    private Integer cryptoCoinId;
    private Integer quoteCoinId;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteExchangeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteExchangeBean)) {
            return false;
        }
        LiteExchangeBean liteExchangeBean = (LiteExchangeBean) obj;
        if (!liteExchangeBean.canEqual(this)) {
            return false;
        }
        Integer quoteCoinId2 = getQuoteCoinId();
        Integer quoteCoinId3 = liteExchangeBean.getQuoteCoinId();
        if (quoteCoinId2 != null ? !quoteCoinId2.equals(quoteCoinId3) : quoteCoinId3 != null) {
            return false;
        }
        Integer cryptoCoinId2 = getCryptoCoinId();
        Integer cryptoCoinId3 = liteExchangeBean.getCryptoCoinId();
        return cryptoCoinId2 != null ? cryptoCoinId2.equals(cryptoCoinId3) : cryptoCoinId3 == null;
    }

    public Integer getCryptoCoinId() {
        return this.cryptoCoinId;
    }

    public Integer getQuoteCoinId() {
        return this.quoteCoinId;
    }

    public int hashCode() {
        Integer quoteCoinId2 = getQuoteCoinId();
        int i11 = 43;
        int hashCode = quoteCoinId2 == null ? 43 : quoteCoinId2.hashCode();
        Integer cryptoCoinId2 = getCryptoCoinId();
        int i12 = (hashCode + 59) * 59;
        if (cryptoCoinId2 != null) {
            i11 = cryptoCoinId2.hashCode();
        }
        return i12 + i11;
    }

    public void setCryptoCoinId(Integer num) {
        this.cryptoCoinId = num;
    }

    public void setQuoteCoinId(Integer num) {
        this.quoteCoinId = num;
    }

    public String toString() {
        return "LiteExchangeBean(quoteCoinId=" + getQuoteCoinId() + ", cryptoCoinId=" + getCryptoCoinId() + ")";
    }
}
