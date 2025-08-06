package com.huobi.otc.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class OtherInfoBean implements Serializable {
    private int appealMonthTimes;
    private int appealMonthWinTimes;
    private String gmtCreate;
    private boolean isOnline;
    private boolean isSeniorAuth;
    private BigDecimal marginAmount;
    private int marginCoinId;
    private int merchantLevel;
    private int tradeMonthCount;
    private long uid;
    private String userName;

    public boolean canEqual(Object obj) {
        return obj instanceof OtherInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtherInfoBean)) {
            return false;
        }
        OtherInfoBean otherInfoBean = (OtherInfoBean) obj;
        if (!otherInfoBean.canEqual(this) || getUid() != otherInfoBean.getUid()) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = otherInfoBean.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        String gmtCreate2 = getGmtCreate();
        String gmtCreate3 = otherInfoBean.getGmtCreate();
        if (gmtCreate2 != null ? !gmtCreate2.equals(gmtCreate3) : gmtCreate3 != null) {
            return false;
        }
        if (getMerchantLevel() != otherInfoBean.getMerchantLevel() || getMarginCoinId() != otherInfoBean.getMarginCoinId()) {
            return false;
        }
        BigDecimal marginAmount2 = getMarginAmount();
        BigDecimal marginAmount3 = otherInfoBean.getMarginAmount();
        if (marginAmount2 != null ? marginAmount2.equals(marginAmount3) : marginAmount3 == null) {
            return getAppealMonthTimes() == otherInfoBean.getAppealMonthTimes() && getAppealMonthWinTimes() == otherInfoBean.getAppealMonthWinTimes() && getTradeMonthCount() == otherInfoBean.getTradeMonthCount() && isOnline() == otherInfoBean.isOnline() && isSeniorAuth() == otherInfoBean.isSeniorAuth();
        }
        return false;
    }

    public int getAppealMonthTimes() {
        return this.appealMonthTimes;
    }

    public int getAppealMonthWinTimes() {
        return this.appealMonthWinTimes;
    }

    public String getGmtCreate() {
        return this.gmtCreate;
    }

    public BigDecimal getMarginAmount() {
        return this.marginAmount;
    }

    public int getMarginCoinId() {
        return this.marginCoinId;
    }

    public int getMerchantLevel() {
        return this.merchantLevel;
    }

    public int getTradeMonthCount() {
        return this.tradeMonthCount;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        long uid2 = getUid();
        String userName2 = getUserName();
        int i11 = 43;
        int hashCode = ((((int) (uid2 ^ (uid2 >>> 32))) + 59) * 59) + (userName2 == null ? 43 : userName2.hashCode());
        String gmtCreate2 = getGmtCreate();
        int hashCode2 = (((((hashCode * 59) + (gmtCreate2 == null ? 43 : gmtCreate2.hashCode())) * 59) + getMerchantLevel()) * 59) + getMarginCoinId();
        BigDecimal marginAmount2 = getMarginAmount();
        int i12 = hashCode2 * 59;
        if (marginAmount2 != null) {
            i11 = marginAmount2.hashCode();
        }
        int appealMonthTimes2 = (((((((i12 + i11) * 59) + getAppealMonthTimes()) * 59) + getAppealMonthWinTimes()) * 59) + getTradeMonthCount()) * 59;
        int i13 = 79;
        int i14 = (appealMonthTimes2 + (isOnline() ? 79 : 97)) * 59;
        if (!isSeniorAuth()) {
            i13 = 97;
        }
        return i14 + i13;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public boolean isSeniorAuth() {
        return this.isSeniorAuth;
    }

    public void setAppealMonthTimes(int i11) {
        this.appealMonthTimes = i11;
    }

    public void setAppealMonthWinTimes(int i11) {
        this.appealMonthWinTimes = i11;
    }

    public void setGmtCreate(String str) {
        this.gmtCreate = str;
    }

    public void setMarginAmount(BigDecimal bigDecimal) {
        this.marginAmount = bigDecimal;
    }

    public void setMarginCoinId(int i11) {
        this.marginCoinId = i11;
    }

    public void setMerchantLevel(int i11) {
        this.merchantLevel = i11;
    }

    public void setOnline(boolean z11) {
        this.isOnline = z11;
    }

    public void setSeniorAuth(boolean z11) {
        this.isSeniorAuth = z11;
    }

    public void setTradeMonthCount(int i11) {
        this.tradeMonthCount = i11;
    }

    public void setUid(long j11) {
        this.uid = j11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "OtherInfoBean(uid=" + getUid() + ", userName=" + getUserName() + ", gmtCreate=" + getGmtCreate() + ", merchantLevel=" + getMerchantLevel() + ", marginCoinId=" + getMarginCoinId() + ", marginAmount=" + getMarginAmount() + ", appealMonthTimes=" + getAppealMonthTimes() + ", appealMonthWinTimes=" + getAppealMonthWinTimes() + ", tradeMonthCount=" + getTradeMonthCount() + ", isOnline=" + isOnline() + ", isSeniorAuth=" + isSeniorAuth() + ")";
    }
}
