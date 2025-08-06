package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class MerchantInfo implements Serializable {
    private int appealMonthTimes;
    private int appealMonthWinTimes;
    private String appealRate;
    private int appealTimes;
    private int appealWinTimes;
    private int areaType;
    private String gmtCreate;
    private boolean isFollowed;
    private boolean isMailBind;
    private boolean isMerchant;
    private boolean isPhoneBind;
    private String marginAmount;
    private int marginCoinId;
    private int merchantLevel;
    private String monthPayTimeAvg;
    private String monthReleaseTimeAvg;
    private int orderCompleteRate = -1;
    private int realBind;
    private int relationType;
    private int releaseTime = -1;
    private int thumbUp;
    private int tradeCount = -1;
    private int tradeCountBuy;
    private int tradeCountSell;
    private int tradeLevel;
    private int tradeMonthCount = -1;
    private int tradeMonthCountBuy;
    private int tradeMonthCountSell;
    private String userName;

    public boolean canEqual(Object obj) {
        return obj instanceof MerchantInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MerchantInfo)) {
            return false;
        }
        MerchantInfo merchantInfo = (MerchantInfo) obj;
        if (!merchantInfo.canEqual(this)) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = merchantInfo.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (isPhoneBind() != merchantInfo.isPhoneBind() || isMailBind() != merchantInfo.isMailBind() || getRealBind() != merchantInfo.getRealBind()) {
            return false;
        }
        String gmtCreate2 = getGmtCreate();
        String gmtCreate3 = merchantInfo.getGmtCreate();
        if (gmtCreate2 != null ? !gmtCreate2.equals(gmtCreate3) : gmtCreate3 != null) {
            return false;
        }
        if (isMerchant() != merchantInfo.isMerchant() || getMerchantLevel() != merchantInfo.getMerchantLevel() || getThumbUp() != merchantInfo.getThumbUp() || getTradeLevel() != merchantInfo.getTradeLevel() || getMarginCoinId() != merchantInfo.getMarginCoinId()) {
            return false;
        }
        String marginAmount2 = getMarginAmount();
        String marginAmount3 = merchantInfo.getMarginAmount();
        if (marginAmount2 != null ? !marginAmount2.equals(marginAmount3) : marginAmount3 != null) {
            return false;
        }
        if (getTradeCount() != merchantInfo.getTradeCount() || getReleaseTime() != merchantInfo.getReleaseTime() || getAppealTimes() != merchantInfo.getAppealTimes() || getAppealWinTimes() != merchantInfo.getAppealWinTimes() || getAppealMonthTimes() != merchantInfo.getAppealMonthTimes() || getAppealMonthWinTimes() != merchantInfo.getAppealMonthWinTimes() || getTradeMonthCount() != merchantInfo.getTradeMonthCount() || getOrderCompleteRate() != merchantInfo.getOrderCompleteRate() || getAreaType() != merchantInfo.getAreaType() || getTradeCountSell() != merchantInfo.getTradeCountSell() || getTradeCountBuy() != merchantInfo.getTradeCountBuy() || getTradeMonthCountBuy() != merchantInfo.getTradeMonthCountBuy() || getTradeMonthCountSell() != merchantInfo.getTradeMonthCountSell()) {
            return false;
        }
        String appealRate2 = getAppealRate();
        String appealRate3 = merchantInfo.getAppealRate();
        if (appealRate2 != null ? !appealRate2.equals(appealRate3) : appealRate3 != null) {
            return false;
        }
        String monthReleaseTimeAvg2 = getMonthReleaseTimeAvg();
        String monthReleaseTimeAvg3 = merchantInfo.getMonthReleaseTimeAvg();
        if (monthReleaseTimeAvg2 != null ? !monthReleaseTimeAvg2.equals(monthReleaseTimeAvg3) : monthReleaseTimeAvg3 != null) {
            return false;
        }
        String monthPayTimeAvg2 = getMonthPayTimeAvg();
        String monthPayTimeAvg3 = merchantInfo.getMonthPayTimeAvg();
        if (monthPayTimeAvg2 != null ? monthPayTimeAvg2.equals(monthPayTimeAvg3) : monthPayTimeAvg3 == null) {
            return isFollowed() == merchantInfo.isFollowed() && getRelationType() == merchantInfo.getRelationType();
        }
        return false;
    }

    public int getAppealMonthTimes() {
        return this.appealMonthTimes;
    }

    public int getAppealMonthWinTimes() {
        return this.appealMonthWinTimes;
    }

    public String getAppealRate() {
        return this.appealRate;
    }

    public int getAppealTimes() {
        return this.appealTimes;
    }

    public int getAppealWinTimes() {
        return this.appealWinTimes;
    }

    public int getAreaType() {
        return this.areaType;
    }

    public String getGmtCreate() {
        return this.gmtCreate;
    }

    public String getMarginAmount() {
        return this.marginAmount;
    }

    public int getMarginCoinId() {
        return this.marginCoinId;
    }

    public int getMerchantLevel() {
        return this.merchantLevel;
    }

    public String getMonthPayTimeAvg() {
        return this.monthPayTimeAvg;
    }

    public String getMonthReleaseTimeAvg() {
        return this.monthReleaseTimeAvg;
    }

    public int getOrderCompleteRate() {
        return this.orderCompleteRate;
    }

    public int getRealBind() {
        return this.realBind;
    }

    public int getRelationType() {
        return this.relationType;
    }

    public int getReleaseTime() {
        return this.releaseTime;
    }

    public int getThumbUp() {
        return this.thumbUp;
    }

    public int getTradeCount() {
        return this.tradeCount;
    }

    public int getTradeCountBuy() {
        return this.tradeCountBuy;
    }

    public int getTradeCountSell() {
        return this.tradeCountSell;
    }

    public int getTradeLevel() {
        return this.tradeLevel;
    }

    public int getTradeMonthCount() {
        return this.tradeMonthCount;
    }

    public int getTradeMonthCountBuy() {
        return this.tradeMonthCountBuy;
    }

    public int getTradeMonthCountSell() {
        return this.tradeMonthCountSell;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String userName2 = getUserName();
        int i11 = 43;
        int i12 = 79;
        int hashCode = (((((((userName2 == null ? 43 : userName2.hashCode()) + 59) * 59) + (isPhoneBind() ? 79 : 97)) * 59) + (isMailBind() ? 79 : 97)) * 59) + getRealBind();
        String gmtCreate2 = getGmtCreate();
        int hashCode2 = (((((((((((hashCode * 59) + (gmtCreate2 == null ? 43 : gmtCreate2.hashCode())) * 59) + (isMerchant() ? 79 : 97)) * 59) + getMerchantLevel()) * 59) + getThumbUp()) * 59) + getTradeLevel()) * 59) + getMarginCoinId();
        String marginAmount2 = getMarginAmount();
        int hashCode3 = (((((((((((((((((((((((((((hashCode2 * 59) + (marginAmount2 == null ? 43 : marginAmount2.hashCode())) * 59) + getTradeCount()) * 59) + getReleaseTime()) * 59) + getAppealTimes()) * 59) + getAppealWinTimes()) * 59) + getAppealMonthTimes()) * 59) + getAppealMonthWinTimes()) * 59) + getTradeMonthCount()) * 59) + getOrderCompleteRate()) * 59) + getAreaType()) * 59) + getTradeCountSell()) * 59) + getTradeCountBuy()) * 59) + getTradeMonthCountBuy()) * 59) + getTradeMonthCountSell();
        String appealRate2 = getAppealRate();
        int hashCode4 = (hashCode3 * 59) + (appealRate2 == null ? 43 : appealRate2.hashCode());
        String monthReleaseTimeAvg2 = getMonthReleaseTimeAvg();
        int hashCode5 = (hashCode4 * 59) + (monthReleaseTimeAvg2 == null ? 43 : monthReleaseTimeAvg2.hashCode());
        String monthPayTimeAvg2 = getMonthPayTimeAvg();
        int i13 = hashCode5 * 59;
        if (monthPayTimeAvg2 != null) {
            i11 = monthPayTimeAvg2.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!isFollowed()) {
            i12 = 97;
        }
        return ((i14 + i12) * 59) + getRelationType();
    }

    public boolean isFollowed() {
        return this.isFollowed;
    }

    public boolean isMailBind() {
        return this.isMailBind;
    }

    public boolean isMerchant() {
        return this.isMerchant;
    }

    public boolean isPhoneBind() {
        return this.isPhoneBind;
    }

    public void setAppealMonthTimes(int i11) {
        this.appealMonthTimes = i11;
    }

    public void setAppealMonthWinTimes(int i11) {
        this.appealMonthWinTimes = i11;
    }

    public void setAppealRate(String str) {
        this.appealRate = str;
    }

    public void setAppealTimes(int i11) {
        this.appealTimes = i11;
    }

    public void setAppealWinTimes(int i11) {
        this.appealWinTimes = i11;
    }

    public void setAreaType(int i11) {
        this.areaType = i11;
    }

    public void setFollowed(boolean z11) {
        this.isFollowed = z11;
    }

    public void setGmtCreate(String str) {
        this.gmtCreate = str;
    }

    public void setMailBind(boolean z11) {
        this.isMailBind = z11;
    }

    public void setMarginAmount(String str) {
        this.marginAmount = str;
    }

    public void setMarginCoinId(int i11) {
        this.marginCoinId = i11;
    }

    public void setMerchant(boolean z11) {
        this.isMerchant = z11;
    }

    public void setMerchantLevel(int i11) {
        this.merchantLevel = i11;
    }

    public void setMonthPayTimeAvg(String str) {
        this.monthPayTimeAvg = str;
    }

    public void setMonthReleaseTimeAvg(String str) {
        this.monthReleaseTimeAvg = str;
    }

    public void setOrderCompleteRate(int i11) {
        this.orderCompleteRate = i11;
    }

    public void setPhoneBind(boolean z11) {
        this.isPhoneBind = z11;
    }

    public void setRealBind(int i11) {
        this.realBind = i11;
    }

    public void setRelationType(int i11) {
        this.relationType = i11;
    }

    public void setReleaseTime(int i11) {
        this.releaseTime = i11;
    }

    public void setThumbUp(int i11) {
        this.thumbUp = i11;
    }

    public void setTradeCount(int i11) {
        this.tradeCount = i11;
    }

    public void setTradeCountBuy(int i11) {
        this.tradeCountBuy = i11;
    }

    public void setTradeCountSell(int i11) {
        this.tradeCountSell = i11;
    }

    public void setTradeLevel(int i11) {
        this.tradeLevel = i11;
    }

    public void setTradeMonthCount(int i11) {
        this.tradeMonthCount = i11;
    }

    public void setTradeMonthCountBuy(int i11) {
        this.tradeMonthCountBuy = i11;
    }

    public void setTradeMonthCountSell(int i11) {
        this.tradeMonthCountSell = i11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "MerchantInfo(userName=" + getUserName() + ", isPhoneBind=" + isPhoneBind() + ", isMailBind=" + isMailBind() + ", realBind=" + getRealBind() + ", gmtCreate=" + getGmtCreate() + ", isMerchant=" + isMerchant() + ", merchantLevel=" + getMerchantLevel() + ", thumbUp=" + getThumbUp() + ", tradeLevel=" + getTradeLevel() + ", marginCoinId=" + getMarginCoinId() + ", marginAmount=" + getMarginAmount() + ", tradeCount=" + getTradeCount() + ", releaseTime=" + getReleaseTime() + ", appealTimes=" + getAppealTimes() + ", appealWinTimes=" + getAppealWinTimes() + ", appealMonthTimes=" + getAppealMonthTimes() + ", appealMonthWinTimes=" + getAppealMonthWinTimes() + ", tradeMonthCount=" + getTradeMonthCount() + ", orderCompleteRate=" + getOrderCompleteRate() + ", areaType=" + getAreaType() + ", tradeCountSell=" + getTradeCountSell() + ", tradeCountBuy=" + getTradeCountBuy() + ", tradeMonthCountBuy=" + getTradeMonthCountBuy() + ", tradeMonthCountSell=" + getTradeMonthCountSell() + ", appealRate=" + getAppealRate() + ", monthReleaseTimeAvg=" + getMonthReleaseTimeAvg() + ", monthPayTimeAvg=" + getMonthPayTimeAvg() + ", isFollowed=" + isFollowed() + ", relationType=" + getRelationType() + ")";
    }
}
