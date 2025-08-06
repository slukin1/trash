package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AssetOptionsInfo implements Serializable {
    @SerializedName("available")
    private String available;
    @SerializedName("currency")
    private String currency;
    @SerializedName("position")
    private String position;
    @SerializedName("profit-loss")
    private String profitLoss;
    @SerializedName("profit-loss-rate")
    private String profitRate;

    public boolean canEqual(Object obj) {
        return obj instanceof AssetOptionsInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetOptionsInfo)) {
            return false;
        }
        AssetOptionsInfo assetOptionsInfo = (AssetOptionsInfo) obj;
        if (!assetOptionsInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = assetOptionsInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String position2 = getPosition();
        String position3 = assetOptionsInfo.getPosition();
        if (position2 != null ? !position2.equals(position3) : position3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = assetOptionsInfo.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String profitLoss2 = getProfitLoss();
        String profitLoss3 = assetOptionsInfo.getProfitLoss();
        if (profitLoss2 != null ? !profitLoss2.equals(profitLoss3) : profitLoss3 != null) {
            return false;
        }
        String profitRate2 = getProfitRate();
        String profitRate3 = assetOptionsInfo.getProfitRate();
        return profitRate2 != null ? profitRate2.equals(profitRate3) : profitRate3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getPosition() {
        return this.position;
    }

    public String getProfitLoss() {
        return this.profitLoss;
    }

    public String getProfitRate() {
        return this.profitRate;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String position2 = getPosition();
        int hashCode2 = ((hashCode + 59) * 59) + (position2 == null ? 43 : position2.hashCode());
        String available2 = getAvailable();
        int hashCode3 = (hashCode2 * 59) + (available2 == null ? 43 : available2.hashCode());
        String profitLoss2 = getProfitLoss();
        int hashCode4 = (hashCode3 * 59) + (profitLoss2 == null ? 43 : profitLoss2.hashCode());
        String profitRate2 = getProfitRate();
        int i12 = hashCode4 * 59;
        if (profitRate2 != null) {
            i11 = profitRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setProfitLoss(String str) {
        this.profitLoss = str;
    }

    public void setProfitRate(String str) {
        this.profitRate = str;
    }

    public String toString() {
        return "AssetOptionsInfo(currency=" + getCurrency() + ", position=" + getPosition() + ", available=" + getAvailable() + ", profitLoss=" + getProfitLoss() + ", profitRate=" + getProfitRate() + ")";
    }
}
