package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.supermargin.viewhandler.LoanCurrencyViewHandler;
import java.io.Serializable;
import s9.a;

public class LoanCurrency implements Serializable, a {
    @SerializedName("currency")
    private String currency;
    @SerializedName("interest-rate")
    private String interestRate;
    @SerializedName("loan-amount")
    private String loanAmount;
    @SerializedName("plf-loan-flag")
    private int plfLoanFlag;
    @SerializedName("remain-loan-quota")
    private String remainLoanQuota;
    @SerializedName("user-loan-min-amount")
    private String userLoanMinAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof LoanCurrency;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoanCurrency)) {
            return false;
        }
        LoanCurrency loanCurrency = (LoanCurrency) obj;
        if (!loanCurrency.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = loanCurrency.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String loanAmount2 = getLoanAmount();
        String loanAmount3 = loanCurrency.getLoanAmount();
        if (loanAmount2 != null ? !loanAmount2.equals(loanAmount3) : loanAmount3 != null) {
            return false;
        }
        String remainLoanQuota2 = getRemainLoanQuota();
        String remainLoanQuota3 = loanCurrency.getRemainLoanQuota();
        if (remainLoanQuota2 != null ? !remainLoanQuota2.equals(remainLoanQuota3) : remainLoanQuota3 != null) {
            return false;
        }
        String interestRate2 = getInterestRate();
        String interestRate3 = loanCurrency.getInterestRate();
        if (interestRate2 != null ? !interestRate2.equals(interestRate3) : interestRate3 != null) {
            return false;
        }
        String userLoanMinAmount2 = getUserLoanMinAmount();
        String userLoanMinAmount3 = loanCurrency.getUserLoanMinAmount();
        if (userLoanMinAmount2 != null ? userLoanMinAmount2.equals(userLoanMinAmount3) : userLoanMinAmount3 == null) {
            return getPlfLoanFlag() == loanCurrency.getPlfLoanFlag();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public String getLoanAmount() {
        return this.loanAmount;
    }

    public int getPlfLoanFlag() {
        return this.plfLoanFlag;
    }

    public String getRemainLoanQuota() {
        return this.remainLoanQuota;
    }

    public String getUserLoanMinAmount() {
        return this.userLoanMinAmount;
    }

    public String getViewHandlerName() {
        return LoanCurrencyViewHandler.class.getName();
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String loanAmount2 = getLoanAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (loanAmount2 == null ? 43 : loanAmount2.hashCode());
        String remainLoanQuota2 = getRemainLoanQuota();
        int hashCode3 = (hashCode2 * 59) + (remainLoanQuota2 == null ? 43 : remainLoanQuota2.hashCode());
        String interestRate2 = getInterestRate();
        int hashCode4 = (hashCode3 * 59) + (interestRate2 == null ? 43 : interestRate2.hashCode());
        String userLoanMinAmount2 = getUserLoanMinAmount();
        int i12 = hashCode4 * 59;
        if (userLoanMinAmount2 != null) {
            i11 = userLoanMinAmount2.hashCode();
        }
        return ((i12 + i11) * 59) + getPlfLoanFlag();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public void setLoanAmount(String str) {
        this.loanAmount = str;
    }

    public void setPlfLoanFlag(int i11) {
        this.plfLoanFlag = i11;
    }

    public void setRemainLoanQuota(String str) {
        this.remainLoanQuota = str;
    }

    public void setUserLoanMinAmount(String str) {
        this.userLoanMinAmount = str;
    }

    public String toString() {
        return "LoanCurrency(currency=" + getCurrency() + ", loanAmount=" + getLoanAmount() + ", remainLoanQuota=" + getRemainLoanQuota() + ", interestRate=" + getInterestRate() + ", userLoanMinAmount=" + getUserLoanMinAmount() + ", plfLoanFlag=" + getPlfLoanFlag() + ")";
    }
}
