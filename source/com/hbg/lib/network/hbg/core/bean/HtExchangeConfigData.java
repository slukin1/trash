package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HtExchangeConfigData implements Serializable {
    private String availableNum;
    private String currency;
    private String displayName;
    private String exchangeHtAmount;
    private String positionNum;

    public boolean canEqual(Object obj) {
        return obj instanceof HtExchangeConfigData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HtExchangeConfigData)) {
            return false;
        }
        HtExchangeConfigData htExchangeConfigData = (HtExchangeConfigData) obj;
        if (!htExchangeConfigData.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = htExchangeConfigData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String displayName2 = getDisplayName();
        String displayName3 = htExchangeConfigData.getDisplayName();
        if (displayName2 != null ? !displayName2.equals(displayName3) : displayName3 != null) {
            return false;
        }
        String availableNum2 = getAvailableNum();
        String availableNum3 = htExchangeConfigData.getAvailableNum();
        if (availableNum2 != null ? !availableNum2.equals(availableNum3) : availableNum3 != null) {
            return false;
        }
        String positionNum2 = getPositionNum();
        String positionNum3 = htExchangeConfigData.getPositionNum();
        if (positionNum2 != null ? !positionNum2.equals(positionNum3) : positionNum3 != null) {
            return false;
        }
        String exchangeHtAmount2 = getExchangeHtAmount();
        String exchangeHtAmount3 = htExchangeConfigData.getExchangeHtAmount();
        return exchangeHtAmount2 != null ? exchangeHtAmount2.equals(exchangeHtAmount3) : exchangeHtAmount3 == null;
    }

    public String getAvailableNum() {
        return this.availableNum;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getExchangeHtAmount() {
        return this.exchangeHtAmount;
    }

    public String getPositionNum() {
        return this.positionNum;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String displayName2 = getDisplayName();
        int hashCode2 = ((hashCode + 59) * 59) + (displayName2 == null ? 43 : displayName2.hashCode());
        String availableNum2 = getAvailableNum();
        int hashCode3 = (hashCode2 * 59) + (availableNum2 == null ? 43 : availableNum2.hashCode());
        String positionNum2 = getPositionNum();
        int hashCode4 = (hashCode3 * 59) + (positionNum2 == null ? 43 : positionNum2.hashCode());
        String exchangeHtAmount2 = getExchangeHtAmount();
        int i12 = hashCode4 * 59;
        if (exchangeHtAmount2 != null) {
            i11 = exchangeHtAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableNum(String str) {
        this.availableNum = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setExchangeHtAmount(String str) {
        this.exchangeHtAmount = str;
    }

    public void setPositionNum(String str) {
        this.positionNum = str;
    }

    public String toString() {
        return "HtExchangeConfigData(currency=" + getCurrency() + ", displayName=" + getDisplayName() + ", availableNum=" + getAvailableNum() + ", positionNum=" + getPositionNum() + ", exchangeHtAmount=" + getExchangeHtAmount() + ")";
    }
}
