package com.huobi.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CloudWalletInfo implements Serializable {
    @SerializedName("currency_character")
    public String currencyCharacter;
    @SerializedName("currency_rate")
    private String currencyRate;
    @SerializedName("currency_unit")
    private String currencyUnit;

    public boolean canEqual(Object obj) {
        return obj instanceof CloudWalletInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CloudWalletInfo)) {
            return false;
        }
        CloudWalletInfo cloudWalletInfo = (CloudWalletInfo) obj;
        if (!cloudWalletInfo.canEqual(this)) {
            return false;
        }
        String currencyUnit2 = getCurrencyUnit();
        String currencyUnit3 = cloudWalletInfo.getCurrencyUnit();
        if (currencyUnit2 != null ? !currencyUnit2.equals(currencyUnit3) : currencyUnit3 != null) {
            return false;
        }
        String currencyCharacter2 = getCurrencyCharacter();
        String currencyCharacter3 = cloudWalletInfo.getCurrencyCharacter();
        if (currencyCharacter2 != null ? !currencyCharacter2.equals(currencyCharacter3) : currencyCharacter3 != null) {
            return false;
        }
        String currencyRate2 = getCurrencyRate();
        String currencyRate3 = cloudWalletInfo.getCurrencyRate();
        return currencyRate2 != null ? currencyRate2.equals(currencyRate3) : currencyRate3 == null;
    }

    public String getCurrencyCharacter() {
        return this.currencyCharacter;
    }

    public String getCurrencyRate() {
        return this.currencyRate;
    }

    public String getCurrencyUnit() {
        return this.currencyUnit;
    }

    public int hashCode() {
        String currencyUnit2 = getCurrencyUnit();
        int i11 = 43;
        int hashCode = currencyUnit2 == null ? 43 : currencyUnit2.hashCode();
        String currencyCharacter2 = getCurrencyCharacter();
        int hashCode2 = ((hashCode + 59) * 59) + (currencyCharacter2 == null ? 43 : currencyCharacter2.hashCode());
        String currencyRate2 = getCurrencyRate();
        int i12 = hashCode2 * 59;
        if (currencyRate2 != null) {
            i11 = currencyRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrencyCharacter(String str) {
        this.currencyCharacter = str;
    }

    public void setCurrencyRate(String str) {
        this.currencyRate = str;
    }

    public void setCurrencyUnit(String str) {
        this.currencyUnit = str;
    }

    public String toString() {
        return "CloudWalletInfo(currencyUnit=" + getCurrencyUnit() + ", currencyCharacter=" + getCurrencyCharacter() + ", currencyRate=" + getCurrencyRate() + ")";
    }
}
