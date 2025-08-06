package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CopyTradingAssetInfo implements Serializable {
    private String marginBalance;
    private String marginStatic;
    private String spotAvailable;
    private String spotBalance;
    private String trailFundBalance;
    private String withdrawAvailable;

    public boolean canEqual(Object obj) {
        return obj instanceof CopyTradingAssetInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CopyTradingAssetInfo)) {
            return false;
        }
        CopyTradingAssetInfo copyTradingAssetInfo = (CopyTradingAssetInfo) obj;
        if (!copyTradingAssetInfo.canEqual(this)) {
            return false;
        }
        String marginBalance2 = getMarginBalance();
        String marginBalance3 = copyTradingAssetInfo.getMarginBalance();
        if (marginBalance2 != null ? !marginBalance2.equals(marginBalance3) : marginBalance3 != null) {
            return false;
        }
        String marginStatic2 = getMarginStatic();
        String marginStatic3 = copyTradingAssetInfo.getMarginStatic();
        if (marginStatic2 != null ? !marginStatic2.equals(marginStatic3) : marginStatic3 != null) {
            return false;
        }
        String withdrawAvailable2 = getWithdrawAvailable();
        String withdrawAvailable3 = copyTradingAssetInfo.getWithdrawAvailable();
        if (withdrawAvailable2 != null ? !withdrawAvailable2.equals(withdrawAvailable3) : withdrawAvailable3 != null) {
            return false;
        }
        String spotBalance2 = getSpotBalance();
        String spotBalance3 = copyTradingAssetInfo.getSpotBalance();
        if (spotBalance2 != null ? !spotBalance2.equals(spotBalance3) : spotBalance3 != null) {
            return false;
        }
        String spotAvailable2 = getSpotAvailable();
        String spotAvailable3 = copyTradingAssetInfo.getSpotAvailable();
        if (spotAvailable2 != null ? !spotAvailable2.equals(spotAvailable3) : spotAvailable3 != null) {
            return false;
        }
        String trailFundBalance2 = getTrailFundBalance();
        String trailFundBalance3 = copyTradingAssetInfo.getTrailFundBalance();
        return trailFundBalance2 != null ? trailFundBalance2.equals(trailFundBalance3) : trailFundBalance3 == null;
    }

    public String getMarginBalance() {
        return this.marginBalance;
    }

    public String getMarginStatic() {
        return this.marginStatic;
    }

    public String getSpotAvailable() {
        return this.spotAvailable;
    }

    public String getSpotBalance() {
        return this.spotBalance;
    }

    public String getTrailFundBalance() {
        return this.trailFundBalance;
    }

    public String getWithdrawAvailable() {
        return this.withdrawAvailable;
    }

    public int hashCode() {
        String marginBalance2 = getMarginBalance();
        int i11 = 43;
        int hashCode = marginBalance2 == null ? 43 : marginBalance2.hashCode();
        String marginStatic2 = getMarginStatic();
        int hashCode2 = ((hashCode + 59) * 59) + (marginStatic2 == null ? 43 : marginStatic2.hashCode());
        String withdrawAvailable2 = getWithdrawAvailable();
        int hashCode3 = (hashCode2 * 59) + (withdrawAvailable2 == null ? 43 : withdrawAvailable2.hashCode());
        String spotBalance2 = getSpotBalance();
        int hashCode4 = (hashCode3 * 59) + (spotBalance2 == null ? 43 : spotBalance2.hashCode());
        String spotAvailable2 = getSpotAvailable();
        int hashCode5 = (hashCode4 * 59) + (spotAvailable2 == null ? 43 : spotAvailable2.hashCode());
        String trailFundBalance2 = getTrailFundBalance();
        int i12 = hashCode5 * 59;
        if (trailFundBalance2 != null) {
            i11 = trailFundBalance2.hashCode();
        }
        return i12 + i11;
    }

    public void setMarginBalance(String str) {
        this.marginBalance = str;
    }

    public void setMarginStatic(String str) {
        this.marginStatic = str;
    }

    public void setSpotAvailable(String str) {
        this.spotAvailable = str;
    }

    public void setSpotBalance(String str) {
        this.spotBalance = str;
    }

    public void setTrailFundBalance(String str) {
        this.trailFundBalance = str;
    }

    public void setWithdrawAvailable(String str) {
        this.withdrawAvailable = str;
    }

    public String toString() {
        return "CopyTradingAssetInfo(marginBalance=" + getMarginBalance() + ", marginStatic=" + getMarginStatic() + ", withdrawAvailable=" + getWithdrawAvailable() + ", spotBalance=" + getSpotBalance() + ", spotAvailable=" + getSpotAvailable() + ", trailFundBalance=" + getTrailFundBalance() + ")";
    }
}
