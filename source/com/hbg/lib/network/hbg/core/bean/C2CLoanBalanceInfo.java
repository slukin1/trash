package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CLoanBalanceInfo implements Serializable {
    private String accumulatedIncome;
    private String expectIncome;
    private String filledAmount;
    private String loanMaxAmount;
    private String totalAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CLoanBalanceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CLoanBalanceInfo)) {
            return false;
        }
        C2CLoanBalanceInfo c2CLoanBalanceInfo = (C2CLoanBalanceInfo) obj;
        if (!c2CLoanBalanceInfo.canEqual(this)) {
            return false;
        }
        String filledAmount2 = getFilledAmount();
        String filledAmount3 = c2CLoanBalanceInfo.getFilledAmount();
        if (filledAmount2 != null ? !filledAmount2.equals(filledAmount3) : filledAmount3 != null) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = c2CLoanBalanceInfo.getTotalAmount();
        if (totalAmount2 != null ? !totalAmount2.equals(totalAmount3) : totalAmount3 != null) {
            return false;
        }
        String expectIncome2 = getExpectIncome();
        String expectIncome3 = c2CLoanBalanceInfo.getExpectIncome();
        if (expectIncome2 != null ? !expectIncome2.equals(expectIncome3) : expectIncome3 != null) {
            return false;
        }
        String accumulatedIncome2 = getAccumulatedIncome();
        String accumulatedIncome3 = c2CLoanBalanceInfo.getAccumulatedIncome();
        if (accumulatedIncome2 != null ? !accumulatedIncome2.equals(accumulatedIncome3) : accumulatedIncome3 != null) {
            return false;
        }
        String loanMaxAmount2 = getLoanMaxAmount();
        String loanMaxAmount3 = c2CLoanBalanceInfo.getLoanMaxAmount();
        return loanMaxAmount2 != null ? loanMaxAmount2.equals(loanMaxAmount3) : loanMaxAmount3 == null;
    }

    public String getAccumulatedIncome() {
        return this.accumulatedIncome;
    }

    public String getExpectIncome() {
        return this.expectIncome;
    }

    public String getFilledAmount() {
        return this.filledAmount;
    }

    public String getLoanMaxAmount() {
        return this.loanMaxAmount;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public int hashCode() {
        String filledAmount2 = getFilledAmount();
        int i11 = 43;
        int hashCode = filledAmount2 == null ? 43 : filledAmount2.hashCode();
        String totalAmount2 = getTotalAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (totalAmount2 == null ? 43 : totalAmount2.hashCode());
        String expectIncome2 = getExpectIncome();
        int hashCode3 = (hashCode2 * 59) + (expectIncome2 == null ? 43 : expectIncome2.hashCode());
        String accumulatedIncome2 = getAccumulatedIncome();
        int hashCode4 = (hashCode3 * 59) + (accumulatedIncome2 == null ? 43 : accumulatedIncome2.hashCode());
        String loanMaxAmount2 = getLoanMaxAmount();
        int i12 = hashCode4 * 59;
        if (loanMaxAmount2 != null) {
            i11 = loanMaxAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccumulatedIncome(String str) {
        this.accumulatedIncome = str;
    }

    public void setExpectIncome(String str) {
        this.expectIncome = str;
    }

    public void setFilledAmount(String str) {
        this.filledAmount = str;
    }

    public void setLoanMaxAmount(String str) {
        this.loanMaxAmount = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String toString() {
        return "C2CLoanBalanceInfo(filledAmount=" + getFilledAmount() + ", totalAmount=" + getTotalAmount() + ", expectIncome=" + getExpectIncome() + ", accumulatedIncome=" + getAccumulatedIncome() + ", loanMaxAmount=" + getLoanMaxAmount() + ")";
    }
}
