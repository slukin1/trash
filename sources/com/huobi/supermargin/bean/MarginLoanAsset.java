package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;

public class MarginLoanAsset implements Serializable {
    private static final long serialVersionUID = 3820556146264335068L;
    private String currency;
    @SerializedName("interest-amount")
    private String interestAmount;
    @SerializedName("interest-rate")
    private String interestRate;
    @SerializedName("loan-amount")
    private String loanAmount;
    @SerializedName("remain-loan-quota")
    private String remainLoanQuota;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginLoanAsset;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginLoanAsset)) {
            return false;
        }
        MarginLoanAsset marginLoanAsset = (MarginLoanAsset) obj;
        if (!marginLoanAsset.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = marginLoanAsset.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String loanAmount2 = getLoanAmount();
        String loanAmount3 = marginLoanAsset.getLoanAmount();
        if (loanAmount2 != null ? !loanAmount2.equals(loanAmount3) : loanAmount3 != null) {
            return false;
        }
        String remainLoanQuota2 = getRemainLoanQuota();
        String remainLoanQuota3 = marginLoanAsset.getRemainLoanQuota();
        if (remainLoanQuota2 != null ? !remainLoanQuota2.equals(remainLoanQuota3) : remainLoanQuota3 != null) {
            return false;
        }
        String interestRate2 = getInterestRate();
        String interestRate3 = marginLoanAsset.getInterestRate();
        if (interestRate2 != null ? !interestRate2.equals(interestRate3) : interestRate3 != null) {
            return false;
        }
        String interestAmount2 = getInterestAmount();
        String interestAmount3 = marginLoanAsset.getInterestAmount();
        return interestAmount2 != null ? interestAmount2.equals(interestAmount3) : interestAmount3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getInterestAmount() {
        return this.interestAmount;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public String getLoanAmount() {
        return this.loanAmount;
    }

    public BigDecimal getLoanAndInterest() {
        return m.a(this.loanAmount).add(m.a(this.interestAmount));
    }

    public String getRemainLoanQuota() {
        return this.remainLoanQuota;
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
        String interestAmount2 = getInterestAmount();
        int i12 = hashCode4 * 59;
        if (interestAmount2 != null) {
            i11 = interestAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setInterestAmount(String str) {
        this.interestAmount = str;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public void setLoanAmount(String str) {
        this.loanAmount = str;
    }

    public void setRemainLoanQuota(String str) {
        this.remainLoanQuota = str;
    }

    public String toString() {
        return "MarginLoanAsset(currency=" + getCurrency() + ", loanAmount=" + getLoanAmount() + ", remainLoanQuota=" + getRemainLoanQuota() + ", interestRate=" + getInterestRate() + ", interestAmount=" + getInterestAmount() + ")";
    }
}
