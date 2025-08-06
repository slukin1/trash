package com.huobi.finance.bean;

import android.text.TextUtils;
import com.huobi.finance.viewhandler.SavingsBalanceViewAdapter;

public class SavingsDetailInfo extends BalanceDetailInfo {
    private String earning;
    private String lending;

    public boolean canEqual(Object obj) {
        return obj instanceof SavingsDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SavingsDetailInfo)) {
            return false;
        }
        SavingsDetailInfo savingsDetailInfo = (SavingsDetailInfo) obj;
        if (!savingsDetailInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String earning2 = getEarning();
        String earning3 = savingsDetailInfo.getEarning();
        if (earning2 != null ? !earning2.equals(earning3) : earning3 != null) {
            return false;
        }
        String lending2 = getLending();
        String lending3 = savingsDetailInfo.getLending();
        return lending2 != null ? lending2.equals(lending3) : lending3 == null;
    }

    public String getAvaialAble() {
        String avaialAble = super.getAvaialAble();
        return TextUtils.isEmpty(avaialAble) ? "0.00" : avaialAble;
    }

    public String getEarning() {
        return this.earning;
    }

    public String getLending() {
        return this.lending;
    }

    public String getTitle() {
        return getCurrency();
    }

    public String getViewHandlerName() {
        return SavingsBalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String earning2 = getEarning();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (earning2 == null ? 43 : earning2.hashCode());
        String lending2 = getLending();
        int i12 = hashCode2 * 59;
        if (lending2 != null) {
            i11 = lending2.hashCode();
        }
        return i12 + i11;
    }

    public void setEarning(String str) {
        this.earning = str;
    }

    public void setLending(String str) {
        this.lending = str;
    }

    public String toString() {
        return "SavingsDetailInfo(earning=" + getEarning() + ", lending=" + getLending() + ")";
    }
}
