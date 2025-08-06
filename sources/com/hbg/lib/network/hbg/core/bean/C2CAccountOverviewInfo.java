package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CAccountOverviewInfo implements Serializable {
    public static final int ACCOUNT_RISK_STATE_HAVE = 2;
    public static final int ACCOUNT_RISK_STATE_HIGH = 1;
    public static final int ACCOUNT_RISK_STATE_LIQUIDATION = 0;
    public static final int ACCOUNT_RISK_STATE_NEGATIVE = -1;
    public static final int ACCOUNT_RISK_STATE_NO = 3;
    private String availableBaseAmount;
    private String availableQuoteAmount;
    private String borrowedBaseAmount;
    private String borrowedQuoteAmount;
    private String interestBaseAmount;
    private String interestQuoteAmount;
    private String riskRate;
    private int riskState;
    private String totalAmount;
    private String totalLoanAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CAccountOverviewInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CAccountOverviewInfo)) {
            return false;
        }
        C2CAccountOverviewInfo c2CAccountOverviewInfo = (C2CAccountOverviewInfo) obj;
        if (!c2CAccountOverviewInfo.canEqual(this)) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = c2CAccountOverviewInfo.getTotalAmount();
        if (totalAmount2 != null ? !totalAmount2.equals(totalAmount3) : totalAmount3 != null) {
            return false;
        }
        String totalLoanAmount2 = getTotalLoanAmount();
        String totalLoanAmount3 = c2CAccountOverviewInfo.getTotalLoanAmount();
        if (totalLoanAmount2 != null ? !totalLoanAmount2.equals(totalLoanAmount3) : totalLoanAmount3 != null) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = c2CAccountOverviewInfo.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        if (getRiskState() != c2CAccountOverviewInfo.getRiskState()) {
            return false;
        }
        String availableQuoteAmount2 = getAvailableQuoteAmount();
        String availableQuoteAmount3 = c2CAccountOverviewInfo.getAvailableQuoteAmount();
        if (availableQuoteAmount2 != null ? !availableQuoteAmount2.equals(availableQuoteAmount3) : availableQuoteAmount3 != null) {
            return false;
        }
        String borrowedQuoteAmount2 = getBorrowedQuoteAmount();
        String borrowedQuoteAmount3 = c2CAccountOverviewInfo.getBorrowedQuoteAmount();
        if (borrowedQuoteAmount2 != null ? !borrowedQuoteAmount2.equals(borrowedQuoteAmount3) : borrowedQuoteAmount3 != null) {
            return false;
        }
        String availableBaseAmount2 = getAvailableBaseAmount();
        String availableBaseAmount3 = c2CAccountOverviewInfo.getAvailableBaseAmount();
        if (availableBaseAmount2 != null ? !availableBaseAmount2.equals(availableBaseAmount3) : availableBaseAmount3 != null) {
            return false;
        }
        String borrowedBaseAmount2 = getBorrowedBaseAmount();
        String borrowedBaseAmount3 = c2CAccountOverviewInfo.getBorrowedBaseAmount();
        if (borrowedBaseAmount2 != null ? !borrowedBaseAmount2.equals(borrowedBaseAmount3) : borrowedBaseAmount3 != null) {
            return false;
        }
        String interestBaseAmount2 = getInterestBaseAmount();
        String interestBaseAmount3 = c2CAccountOverviewInfo.getInterestBaseAmount();
        if (interestBaseAmount2 != null ? !interestBaseAmount2.equals(interestBaseAmount3) : interestBaseAmount3 != null) {
            return false;
        }
        String interestQuoteAmount2 = getInterestQuoteAmount();
        String interestQuoteAmount3 = c2CAccountOverviewInfo.getInterestQuoteAmount();
        return interestQuoteAmount2 != null ? interestQuoteAmount2.equals(interestQuoteAmount3) : interestQuoteAmount3 == null;
    }

    public String getAvailableBaseAmount() {
        return this.availableBaseAmount;
    }

    public String getAvailableQuoteAmount() {
        return this.availableQuoteAmount;
    }

    public String getBorrowedBaseAmount() {
        return this.borrowedBaseAmount;
    }

    public String getBorrowedQuoteAmount() {
        return this.borrowedQuoteAmount;
    }

    public String getInterestBaseAmount() {
        return this.interestBaseAmount;
    }

    public String getInterestQuoteAmount() {
        return this.interestQuoteAmount;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public int getRiskState() {
        return this.riskState;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTotalLoanAmount() {
        return this.totalLoanAmount;
    }

    public int hashCode() {
        String totalAmount2 = getTotalAmount();
        int i11 = 43;
        int hashCode = totalAmount2 == null ? 43 : totalAmount2.hashCode();
        String totalLoanAmount2 = getTotalLoanAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (totalLoanAmount2 == null ? 43 : totalLoanAmount2.hashCode());
        String riskRate2 = getRiskRate();
        int hashCode3 = (((hashCode2 * 59) + (riskRate2 == null ? 43 : riskRate2.hashCode())) * 59) + getRiskState();
        String availableQuoteAmount2 = getAvailableQuoteAmount();
        int hashCode4 = (hashCode3 * 59) + (availableQuoteAmount2 == null ? 43 : availableQuoteAmount2.hashCode());
        String borrowedQuoteAmount2 = getBorrowedQuoteAmount();
        int hashCode5 = (hashCode4 * 59) + (borrowedQuoteAmount2 == null ? 43 : borrowedQuoteAmount2.hashCode());
        String availableBaseAmount2 = getAvailableBaseAmount();
        int hashCode6 = (hashCode5 * 59) + (availableBaseAmount2 == null ? 43 : availableBaseAmount2.hashCode());
        String borrowedBaseAmount2 = getBorrowedBaseAmount();
        int hashCode7 = (hashCode6 * 59) + (borrowedBaseAmount2 == null ? 43 : borrowedBaseAmount2.hashCode());
        String interestBaseAmount2 = getInterestBaseAmount();
        int hashCode8 = (hashCode7 * 59) + (interestBaseAmount2 == null ? 43 : interestBaseAmount2.hashCode());
        String interestQuoteAmount2 = getInterestQuoteAmount();
        int i12 = hashCode8 * 59;
        if (interestQuoteAmount2 != null) {
            i11 = interestQuoteAmount2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isHighRisk() {
        int i11 = this.riskState;
        return -1 == i11 || 1 == i11 || i11 == 0;
    }

    public boolean isLiquidation() {
        return this.riskState == 0;
    }

    public boolean isNegativeAccount() {
        return -1 == this.riskState;
    }

    public void setAvailableBaseAmount(String str) {
        this.availableBaseAmount = str;
    }

    public void setAvailableQuoteAmount(String str) {
        this.availableQuoteAmount = str;
    }

    public void setBorrowedBaseAmount(String str) {
        this.borrowedBaseAmount = str;
    }

    public void setBorrowedQuoteAmount(String str) {
        this.borrowedQuoteAmount = str;
    }

    public void setInterestBaseAmount(String str) {
        this.interestBaseAmount = str;
    }

    public void setInterestQuoteAmount(String str) {
        this.interestQuoteAmount = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setRiskState(int i11) {
        this.riskState = i11;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public void setTotalLoanAmount(String str) {
        this.totalLoanAmount = str;
    }

    public String toString() {
        return "C2CAccountOverviewInfo(totalAmount=" + getTotalAmount() + ", totalLoanAmount=" + getTotalLoanAmount() + ", riskRate=" + getRiskRate() + ", riskState=" + getRiskState() + ", availableQuoteAmount=" + getAvailableQuoteAmount() + ", borrowedQuoteAmount=" + getBorrowedQuoteAmount() + ", availableBaseAmount=" + getAvailableBaseAmount() + ", borrowedBaseAmount=" + getBorrowedBaseAmount() + ", interestBaseAmount=" + getInterestBaseAmount() + ", interestQuoteAmount=" + getInterestQuoteAmount() + ")";
    }
}
