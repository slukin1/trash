package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class RedActivityInfo implements Serializable {
    private static final long serialVersionUID = 8210144921793882271L;
    private String currencyCode;
    private String rewardNum;
    private String transactionNum;

    public boolean canEqual(Object obj) {
        return obj instanceof RedActivityInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RedActivityInfo)) {
            return false;
        }
        RedActivityInfo redActivityInfo = (RedActivityInfo) obj;
        if (!redActivityInfo.canEqual(this)) {
            return false;
        }
        String transactionNum2 = getTransactionNum();
        String transactionNum3 = redActivityInfo.getTransactionNum();
        if (transactionNum2 != null ? !transactionNum2.equals(transactionNum3) : transactionNum3 != null) {
            return false;
        }
        String currencyCode2 = getCurrencyCode();
        String currencyCode3 = redActivityInfo.getCurrencyCode();
        if (currencyCode2 != null ? !currencyCode2.equals(currencyCode3) : currencyCode3 != null) {
            return false;
        }
        String rewardNum2 = getRewardNum();
        String rewardNum3 = redActivityInfo.getRewardNum();
        return rewardNum2 != null ? rewardNum2.equals(rewardNum3) : rewardNum3 == null;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public String getRewardNum() {
        return this.rewardNum;
    }

    public String getTransactionNum() {
        return this.transactionNum;
    }

    public int hashCode() {
        String transactionNum2 = getTransactionNum();
        int i11 = 43;
        int hashCode = transactionNum2 == null ? 43 : transactionNum2.hashCode();
        String currencyCode2 = getCurrencyCode();
        int hashCode2 = ((hashCode + 59) * 59) + (currencyCode2 == null ? 43 : currencyCode2.hashCode());
        String rewardNum2 = getRewardNum();
        int i12 = hashCode2 * 59;
        if (rewardNum2 != null) {
            i11 = rewardNum2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public void setRewardNum(String str) {
        this.rewardNum = str;
    }

    public void setTransactionNum(String str) {
        this.transactionNum = str;
    }

    public String toString() {
        return "RedActivityInfo(transactionNum=" + getTransactionNum() + ", currencyCode=" + getCurrencyCode() + ", rewardNum=" + getRewardNum() + ")";
    }
}
