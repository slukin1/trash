package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HomePageNewUserGiftBagData implements Serializable {
    private int abStatus;
    private long curDate;
    private String myPackageUrl;
    private int registryStatus;
    private int show;
    private String subTitle;
    private String takeAwardUrl;
    private int taskProgress;
    private String title;
    private String totalAward;
    private long tradeDate;
    private int tradeTakeStatus;
    private long transferAmountDate;
    private int transferTakeStatus;

    public boolean canEqual(Object obj) {
        return obj instanceof HomePageNewUserGiftBagData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HomePageNewUserGiftBagData)) {
            return false;
        }
        HomePageNewUserGiftBagData homePageNewUserGiftBagData = (HomePageNewUserGiftBagData) obj;
        if (!homePageNewUserGiftBagData.canEqual(this) || getShow() != homePageNewUserGiftBagData.getShow() || getCurDate() != homePageNewUserGiftBagData.getCurDate() || getTransferAmountDate() != homePageNewUserGiftBagData.getTransferAmountDate() || getTradeDate() != homePageNewUserGiftBagData.getTradeDate() || getAbStatus() != homePageNewUserGiftBagData.getAbStatus() || getTaskProgress() != homePageNewUserGiftBagData.getTaskProgress() || getRegistryStatus() != homePageNewUserGiftBagData.getRegistryStatus() || getTransferTakeStatus() != homePageNewUserGiftBagData.getTransferTakeStatus() || getTradeTakeStatus() != homePageNewUserGiftBagData.getTradeTakeStatus()) {
            return false;
        }
        String totalAward2 = getTotalAward();
        String totalAward3 = homePageNewUserGiftBagData.getTotalAward();
        if (totalAward2 != null ? !totalAward2.equals(totalAward3) : totalAward3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = homePageNewUserGiftBagData.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String subTitle2 = getSubTitle();
        String subTitle3 = homePageNewUserGiftBagData.getSubTitle();
        if (subTitle2 != null ? !subTitle2.equals(subTitle3) : subTitle3 != null) {
            return false;
        }
        String takeAwardUrl2 = getTakeAwardUrl();
        String takeAwardUrl3 = homePageNewUserGiftBagData.getTakeAwardUrl();
        if (takeAwardUrl2 != null ? !takeAwardUrl2.equals(takeAwardUrl3) : takeAwardUrl3 != null) {
            return false;
        }
        String myPackageUrl2 = getMyPackageUrl();
        String myPackageUrl3 = homePageNewUserGiftBagData.getMyPackageUrl();
        return myPackageUrl2 != null ? myPackageUrl2.equals(myPackageUrl3) : myPackageUrl3 == null;
    }

    public int getAbStatus() {
        return this.abStatus;
    }

    public long getCurDate() {
        return this.curDate;
    }

    public String getMyPackageUrl() {
        return this.myPackageUrl;
    }

    public int getRegistryStatus() {
        return this.registryStatus;
    }

    public int getShow() {
        return this.show;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTakeAwardUrl() {
        return this.takeAwardUrl;
    }

    public int getTaskProgress() {
        return this.taskProgress;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTotalAward() {
        return this.totalAward;
    }

    public long getTradeDate() {
        return this.tradeDate;
    }

    public int getTradeTakeStatus() {
        return this.tradeTakeStatus;
    }

    public long getTransferAmountDate() {
        return this.transferAmountDate;
    }

    public int getTransferTakeStatus() {
        return this.transferTakeStatus;
    }

    public int hashCode() {
        long curDate2 = getCurDate();
        int show2 = ((getShow() + 59) * 59) + ((int) (curDate2 ^ (curDate2 >>> 32)));
        long transferAmountDate2 = getTransferAmountDate();
        int i11 = (show2 * 59) + ((int) (transferAmountDate2 ^ (transferAmountDate2 >>> 32)));
        long tradeDate2 = getTradeDate();
        int abStatus2 = (((((((((((i11 * 59) + ((int) (tradeDate2 ^ (tradeDate2 >>> 32)))) * 59) + getAbStatus()) * 59) + getTaskProgress()) * 59) + getRegistryStatus()) * 59) + getTransferTakeStatus()) * 59) + getTradeTakeStatus();
        String totalAward2 = getTotalAward();
        int i12 = 43;
        int hashCode = (abStatus2 * 59) + (totalAward2 == null ? 43 : totalAward2.hashCode());
        String title2 = getTitle();
        int hashCode2 = (hashCode * 59) + (title2 == null ? 43 : title2.hashCode());
        String subTitle2 = getSubTitle();
        int hashCode3 = (hashCode2 * 59) + (subTitle2 == null ? 43 : subTitle2.hashCode());
        String takeAwardUrl2 = getTakeAwardUrl();
        int hashCode4 = (hashCode3 * 59) + (takeAwardUrl2 == null ? 43 : takeAwardUrl2.hashCode());
        String myPackageUrl2 = getMyPackageUrl();
        int i13 = hashCode4 * 59;
        if (myPackageUrl2 != null) {
            i12 = myPackageUrl2.hashCode();
        }
        return i13 + i12;
    }

    public void setAbStatus(int i11) {
        this.abStatus = i11;
    }

    public void setCurDate(long j11) {
        this.curDate = j11;
    }

    public void setMyPackageUrl(String str) {
        this.myPackageUrl = str;
    }

    public void setRegistryStatus(int i11) {
        this.registryStatus = i11;
    }

    public void setShow(int i11) {
        this.show = i11;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setTakeAwardUrl(String str) {
        this.takeAwardUrl = str;
    }

    public void setTaskProgress(int i11) {
        this.taskProgress = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotalAward(String str) {
        this.totalAward = str;
    }

    public void setTradeDate(long j11) {
        this.tradeDate = j11;
    }

    public void setTradeTakeStatus(int i11) {
        this.tradeTakeStatus = i11;
    }

    public void setTransferAmountDate(long j11) {
        this.transferAmountDate = j11;
    }

    public void setTransferTakeStatus(int i11) {
        this.transferTakeStatus = i11;
    }

    public String toString() {
        return "HomePageNewUserGiftBagData{show=" + this.show + ", curDate=" + this.curDate + ", transferAmountDate=" + this.transferAmountDate + ", tradeDate=" + this.tradeDate + ", abStatus=" + this.abStatus + ", taskProgress=" + this.taskProgress + ", registryStatus=" + this.registryStatus + ", transferTakeStatus=" + this.transferTakeStatus + ", tradeTakeStatus=" + this.tradeTakeStatus + ", totalAward=" + this.totalAward + ", title='" + this.title + '\'' + ", subTitle='" + this.subTitle + '\'' + ", takeAwardUrl='" + this.takeAwardUrl + '\'' + ", myPackageUrl='" + this.myPackageUrl + '\'' + '}';
    }
}
