package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class BaseTradingHoseBean implements Serializable {
    private String baseCoinAmount;
    private int baseCoinId;
    private int matchType;
    private String quoteCoinAmount;
    private int quoteCoinId;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseTradingHoseBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseTradingHoseBean)) {
            return false;
        }
        BaseTradingHoseBean baseTradingHoseBean = (BaseTradingHoseBean) obj;
        if (!baseTradingHoseBean.canEqual(this) || getBaseCoinId() != baseTradingHoseBean.getBaseCoinId() || getQuoteCoinId() != baseTradingHoseBean.getQuoteCoinId()) {
            return false;
        }
        String baseCoinAmount2 = getBaseCoinAmount();
        String baseCoinAmount3 = baseTradingHoseBean.getBaseCoinAmount();
        if (baseCoinAmount2 != null ? !baseCoinAmount2.equals(baseCoinAmount3) : baseCoinAmount3 != null) {
            return false;
        }
        String quoteCoinAmount2 = getQuoteCoinAmount();
        String quoteCoinAmount3 = baseTradingHoseBean.getQuoteCoinAmount();
        if (quoteCoinAmount2 != null ? quoteCoinAmount2.equals(quoteCoinAmount3) : quoteCoinAmount3 == null) {
            return getMatchType() == baseTradingHoseBean.getMatchType();
        }
        return false;
    }

    public String getBaseCoinAmount() {
        return this.baseCoinAmount;
    }

    public int getBaseCoinId() {
        return this.baseCoinId;
    }

    public int getMatchType() {
        return this.matchType;
    }

    public String getQuoteCoinAmount() {
        return this.quoteCoinAmount;
    }

    public int getQuoteCoinId() {
        return this.quoteCoinId;
    }

    public int hashCode() {
        int baseCoinId2 = ((getBaseCoinId() + 59) * 59) + getQuoteCoinId();
        String baseCoinAmount2 = getBaseCoinAmount();
        int i11 = 43;
        int hashCode = (baseCoinId2 * 59) + (baseCoinAmount2 == null ? 43 : baseCoinAmount2.hashCode());
        String quoteCoinAmount2 = getQuoteCoinAmount();
        int i12 = hashCode * 59;
        if (quoteCoinAmount2 != null) {
            i11 = quoteCoinAmount2.hashCode();
        }
        return ((i12 + i11) * 59) + getMatchType();
    }

    public void setBaseCoinAmount(String str) {
        this.baseCoinAmount = str;
    }

    public void setBaseCoinId(int i11) {
        this.baseCoinId = i11;
    }

    public void setMatchType(int i11) {
        this.matchType = i11;
    }

    public void setQuoteCoinAmount(String str) {
        this.quoteCoinAmount = str;
    }

    public void setQuoteCoinId(int i11) {
        this.quoteCoinId = i11;
    }

    public String toString() {
        return "BaseTradingHoseBean(baseCoinId=" + getBaseCoinId() + ", quoteCoinId=" + getQuoteCoinId() + ", baseCoinAmount=" + getBaseCoinAmount() + ", quoteCoinAmount=" + getQuoteCoinAmount() + ", matchType=" + getMatchType() + ")";
    }
}
