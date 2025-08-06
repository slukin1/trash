package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RepayCurrency implements Serializable {
    @SerializedName("currency")
    private String currency;
    @SerializedName("interest-amount")
    private String interestAmount;
    @SerializedName("loan-amount")
    private String loanamount;
    @SerializedName("payable-amount")
    private String payableAmount;
    @SerializedName("user-loan-min-amount")
    private String userLoanMinAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof RepayCurrency;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RepayCurrency)) {
            return false;
        }
        RepayCurrency repayCurrency = (RepayCurrency) obj;
        if (!repayCurrency.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = repayCurrency.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String loanamount2 = getLoanamount();
        String loanamount3 = repayCurrency.getLoanamount();
        if (loanamount2 != null ? !loanamount2.equals(loanamount3) : loanamount3 != null) {
            return false;
        }
        String interestAmount2 = getInterestAmount();
        String interestAmount3 = repayCurrency.getInterestAmount();
        if (interestAmount2 != null ? !interestAmount2.equals(interestAmount3) : interestAmount3 != null) {
            return false;
        }
        String payableAmount2 = getPayableAmount();
        String payableAmount3 = repayCurrency.getPayableAmount();
        if (payableAmount2 != null ? !payableAmount2.equals(payableAmount3) : payableAmount3 != null) {
            return false;
        }
        String userLoanMinAmount2 = getUserLoanMinAmount();
        String userLoanMinAmount3 = repayCurrency.getUserLoanMinAmount();
        return userLoanMinAmount2 != null ? userLoanMinAmount2.equals(userLoanMinAmount3) : userLoanMinAmount3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getInterestAmount() {
        return this.interestAmount;
    }

    public String getLoanamount() {
        return this.loanamount;
    }

    public String getPayableAmount() {
        return this.payableAmount;
    }

    public String getUserLoanMinAmount() {
        return this.userLoanMinAmount;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String loanamount2 = getLoanamount();
        int hashCode2 = ((hashCode + 59) * 59) + (loanamount2 == null ? 43 : loanamount2.hashCode());
        String interestAmount2 = getInterestAmount();
        int hashCode3 = (hashCode2 * 59) + (interestAmount2 == null ? 43 : interestAmount2.hashCode());
        String payableAmount2 = getPayableAmount();
        int hashCode4 = (hashCode3 * 59) + (payableAmount2 == null ? 43 : payableAmount2.hashCode());
        String userLoanMinAmount2 = getUserLoanMinAmount();
        int i12 = hashCode4 * 59;
        if (userLoanMinAmount2 != null) {
            i11 = userLoanMinAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setInterestAmount(String str) {
        this.interestAmount = str;
    }

    public void setLoanamount(String str) {
        this.loanamount = str;
    }

    public void setPayableAmount(String str) {
        this.payableAmount = str;
    }

    public void setUserLoanMinAmount(String str) {
        this.userLoanMinAmount = str;
    }

    public String toString() {
        return "RepayCurrency(currency=" + getCurrency() + ", loanamount=" + getLoanamount() + ", interestAmount=" + getInterestAmount() + ", payableAmount=" + getPayableAmount() + ", userLoanMinAmount=" + getUserLoanMinAmount() + ")";
    }
}
