package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LoanRepay implements Serializable {
    private String currency;
    @SerializedName("currency-amount")
    private String currencyAmount;
    @SerializedName("deduct-currency")
    private String deductCurrency;
    @SerializedName("ht-amount")
    private String htAmount;
    @SerializedName("htx-amount")
    private String htxAmount;
    private String interest;
    @SerializedName("interest-amount")
    private String interestAmount;
    @SerializedName("loan-amount")
    private String loanAmount;
    @SerializedName("loan-time")
    private long loanTime;
    @SerializedName("point-amount")
    private String pointAmount;
    @SerializedName("remain-amount")
    private String remainAmount;
    @SerializedName("repay-amount")
    private String repayAmount;
    @SerializedName("repay-time")
    private long repayTime;
    @SerializedName("trx-amount")
    private String trxAmount;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof LoanRepay;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoanRepay)) {
            return false;
        }
        LoanRepay loanRepay = (LoanRepay) obj;
        if (!loanRepay.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = loanRepay.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (getLoanTime() != loanRepay.getLoanTime()) {
            return false;
        }
        String loanAmount2 = getLoanAmount();
        String loanAmount3 = loanRepay.getLoanAmount();
        if (loanAmount2 != null ? !loanAmount2.equals(loanAmount3) : loanAmount3 != null) {
            return false;
        }
        String remainAmount2 = getRemainAmount();
        String remainAmount3 = loanRepay.getRemainAmount();
        if (remainAmount2 != null ? !remainAmount2.equals(remainAmount3) : remainAmount3 != null) {
            return false;
        }
        String interest2 = getInterest();
        String interest3 = loanRepay.getInterest();
        if (interest2 != null ? !interest2.equals(interest3) : interest3 != null) {
            return false;
        }
        String interestAmount2 = getInterestAmount();
        String interestAmount3 = loanRepay.getInterestAmount();
        if (interestAmount2 != null ? !interestAmount2.equals(interestAmount3) : interestAmount3 != null) {
            return false;
        }
        String htAmount2 = getHtAmount();
        String htAmount3 = loanRepay.getHtAmount();
        if (htAmount2 != null ? !htAmount2.equals(htAmount3) : htAmount3 != null) {
            return false;
        }
        String htxAmount2 = getHtxAmount();
        String htxAmount3 = loanRepay.getHtxAmount();
        if (htxAmount2 != null ? !htxAmount2.equals(htxAmount3) : htxAmount3 != null) {
            return false;
        }
        String trxAmount2 = getTrxAmount();
        String trxAmount3 = loanRepay.getTrxAmount();
        if (trxAmount2 != null ? !trxAmount2.equals(trxAmount3) : trxAmount3 != null) {
            return false;
        }
        String pointAmount2 = getPointAmount();
        String pointAmount3 = loanRepay.getPointAmount();
        if (pointAmount2 != null ? !pointAmount2.equals(pointAmount3) : pointAmount3 != null) {
            return false;
        }
        String currencyAmount2 = getCurrencyAmount();
        String currencyAmount3 = loanRepay.getCurrencyAmount();
        if (currencyAmount2 != null ? !currencyAmount2.equals(currencyAmount3) : currencyAmount3 != null) {
            return false;
        }
        if (getRepayTime() != loanRepay.getRepayTime()) {
            return false;
        }
        String repayAmount2 = getRepayAmount();
        String repayAmount3 = loanRepay.getRepayAmount();
        if (repayAmount2 != null ? !repayAmount2.equals(repayAmount3) : repayAmount3 != null) {
            return false;
        }
        String deductCurrency2 = getDeductCurrency();
        String deductCurrency3 = loanRepay.getDeductCurrency();
        if (deductCurrency2 != null ? !deductCurrency2.equals(deductCurrency3) : deductCurrency3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = loanRepay.getType();
        return type2 != null ? type2.equals(type3) : type3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencyAmount() {
        return this.currencyAmount;
    }

    public String getDeductCurrency() {
        return this.deductCurrency;
    }

    public String getHtAmount() {
        return this.htAmount;
    }

    public String getHtxAmount() {
        return this.htxAmount;
    }

    public String getInterest() {
        return this.interest;
    }

    public String getInterestAmount() {
        return this.interestAmount;
    }

    public String getLoanAmount() {
        return this.loanAmount;
    }

    public long getLoanTime() {
        return this.loanTime;
    }

    public String getPointAmount() {
        return this.pointAmount;
    }

    public String getRemainAmount() {
        return this.remainAmount;
    }

    public String getRepayAmount() {
        return this.repayAmount;
    }

    public long getRepayTime() {
        return this.repayTime;
    }

    public String getTrxAmount() {
        return this.trxAmount;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        long loanTime2 = getLoanTime();
        int i12 = ((hashCode + 59) * 59) + ((int) (loanTime2 ^ (loanTime2 >>> 32)));
        String loanAmount2 = getLoanAmount();
        int hashCode2 = (i12 * 59) + (loanAmount2 == null ? 43 : loanAmount2.hashCode());
        String remainAmount2 = getRemainAmount();
        int hashCode3 = (hashCode2 * 59) + (remainAmount2 == null ? 43 : remainAmount2.hashCode());
        String interest2 = getInterest();
        int hashCode4 = (hashCode3 * 59) + (interest2 == null ? 43 : interest2.hashCode());
        String interestAmount2 = getInterestAmount();
        int hashCode5 = (hashCode4 * 59) + (interestAmount2 == null ? 43 : interestAmount2.hashCode());
        String htAmount2 = getHtAmount();
        int hashCode6 = (hashCode5 * 59) + (htAmount2 == null ? 43 : htAmount2.hashCode());
        String htxAmount2 = getHtxAmount();
        int hashCode7 = (hashCode6 * 59) + (htxAmount2 == null ? 43 : htxAmount2.hashCode());
        String trxAmount2 = getTrxAmount();
        int hashCode8 = (hashCode7 * 59) + (trxAmount2 == null ? 43 : trxAmount2.hashCode());
        String pointAmount2 = getPointAmount();
        int hashCode9 = (hashCode8 * 59) + (pointAmount2 == null ? 43 : pointAmount2.hashCode());
        String currencyAmount2 = getCurrencyAmount();
        int hashCode10 = (hashCode9 * 59) + (currencyAmount2 == null ? 43 : currencyAmount2.hashCode());
        long repayTime2 = getRepayTime();
        int i13 = (hashCode10 * 59) + ((int) (repayTime2 ^ (repayTime2 >>> 32)));
        String repayAmount2 = getRepayAmount();
        int hashCode11 = (i13 * 59) + (repayAmount2 == null ? 43 : repayAmount2.hashCode());
        String deductCurrency2 = getDeductCurrency();
        int hashCode12 = (hashCode11 * 59) + (deductCurrency2 == null ? 43 : deductCurrency2.hashCode());
        String type2 = getType();
        int i14 = hashCode12 * 59;
        if (type2 != null) {
            i11 = type2.hashCode();
        }
        return i14 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyAmount(String str) {
        this.currencyAmount = str;
    }

    public void setDeductCurrency(String str) {
        this.deductCurrency = str;
    }

    public void setHtAmount(String str) {
        this.htAmount = str;
    }

    public void setHtxAmount(String str) {
        this.htxAmount = str;
    }

    public void setInterest(String str) {
        this.interest = str;
    }

    public void setInterestAmount(String str) {
        this.interestAmount = str;
    }

    public void setLoanAmount(String str) {
        this.loanAmount = str;
    }

    public void setLoanTime(long j11) {
        this.loanTime = j11;
    }

    public void setPointAmount(String str) {
        this.pointAmount = str;
    }

    public void setRemainAmount(String str) {
        this.remainAmount = str;
    }

    public void setRepayAmount(String str) {
        this.repayAmount = str;
    }

    public void setRepayTime(long j11) {
        this.repayTime = j11;
    }

    public void setTrxAmount(String str) {
        this.trxAmount = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "LoanRepay(currency=" + getCurrency() + ", loanTime=" + getLoanTime() + ", loanAmount=" + getLoanAmount() + ", remainAmount=" + getRemainAmount() + ", interest=" + getInterest() + ", interestAmount=" + getInterestAmount() + ", htAmount=" + getHtAmount() + ", htxAmount=" + getHtxAmount() + ", trxAmount=" + getTrxAmount() + ", pointAmount=" + getPointAmount() + ", currencyAmount=" + getCurrencyAmount() + ", repayTime=" + getRepayTime() + ", repayAmount=" + getRepayAmount() + ", deductCurrency=" + getDeductCurrency() + ", type=" + getType() + ")";
    }
}
