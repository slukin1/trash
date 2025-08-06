package com.huobi.supermargin.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MarginOverview implements Serializable {
    public static final String STATE_HAVE_RISK = "2";
    public static final String STATE_HIGH_RISK = "1";
    public static final String STATE_LIQUIDATION = "0";
    public static final String STATE_NEGATIVE_ACCOUNT = "-1";
    public static final String STATE_NO_RISK = "3";
    private boolean isTradeMargin;
    @SerializedName("leverage-multiple")
    private String leverageMultiple;
    @SerializedName("risk-rate")
    private String riskRate;
    @SerializedName("risk-state")
    private String riskState;
    @SerializedName("total-amount")
    private String totalAmount;
    @SerializedName("total-loan-amount")
    private String totalLoanAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginOverview;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginOverview)) {
            return false;
        }
        MarginOverview marginOverview = (MarginOverview) obj;
        if (!marginOverview.canEqual(this) || isTradeMargin() != marginOverview.isTradeMargin()) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = marginOverview.getTotalAmount();
        if (totalAmount2 != null ? !totalAmount2.equals(totalAmount3) : totalAmount3 != null) {
            return false;
        }
        String totalLoanAmount2 = getTotalLoanAmount();
        String totalLoanAmount3 = marginOverview.getTotalLoanAmount();
        if (totalLoanAmount2 != null ? !totalLoanAmount2.equals(totalLoanAmount3) : totalLoanAmount3 != null) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = marginOverview.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        String leverageMultiple2 = getLeverageMultiple();
        String leverageMultiple3 = marginOverview.getLeverageMultiple();
        if (leverageMultiple2 != null ? !leverageMultiple2.equals(leverageMultiple3) : leverageMultiple3 != null) {
            return false;
        }
        String riskState2 = getRiskState();
        String riskState3 = marginOverview.getRiskState();
        return riskState2 != null ? riskState2.equals(riskState3) : riskState3 == null;
    }

    public String getLeverageMultiple() {
        return this.leverageMultiple;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getRiskState() {
        return this.riskState;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTotalLoanAmount() {
        return this.totalLoanAmount;
    }

    public int hashCode() {
        int i11 = isTradeMargin() ? 79 : 97;
        String totalAmount2 = getTotalAmount();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (totalAmount2 == null ? 43 : totalAmount2.hashCode());
        String totalLoanAmount2 = getTotalLoanAmount();
        int hashCode2 = (hashCode * 59) + (totalLoanAmount2 == null ? 43 : totalLoanAmount2.hashCode());
        String riskRate2 = getRiskRate();
        int hashCode3 = (hashCode2 * 59) + (riskRate2 == null ? 43 : riskRate2.hashCode());
        String leverageMultiple2 = getLeverageMultiple();
        int hashCode4 = (hashCode3 * 59) + (leverageMultiple2 == null ? 43 : leverageMultiple2.hashCode());
        String riskState2 = getRiskState();
        int i13 = hashCode4 * 59;
        if (riskState2 != null) {
            i12 = riskState2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isHighRisk() {
        return "1".equals(this.riskState);
    }

    public boolean isHighRiskOrAbove() {
        return "-1".equals(this.riskState) || "1".equals(this.riskState) || "0".equals(this.riskState);
    }

    public boolean isLiquidation() {
        return "0".equals(this.riskState);
    }

    public boolean isLowRisk() {
        return "2".equals(this.riskState);
    }

    public boolean isNegativeAccount() {
        return "-1".equals(this.riskState);
    }

    public boolean isNoRisk() {
        return "3".equals(this.riskState);
    }

    public boolean isTradeMargin() {
        return this.isTradeMargin;
    }

    public void setLeverageMultiple(String str) {
        this.leverageMultiple = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setRiskState(String str) {
        this.riskState = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public void setTotalLoanAmount(String str) {
        this.totalLoanAmount = str;
    }

    public void setTradeMargin(boolean z11) {
        this.isTradeMargin = z11;
    }

    public String toString() {
        return "MarginOverview(isTradeMargin=" + isTradeMargin() + ", totalAmount=" + getTotalAmount() + ", totalLoanAmount=" + getTotalLoanAmount() + ", riskRate=" + getRiskRate() + ", leverageMultiple=" + getLeverageMultiple() + ", riskState=" + getRiskState() + ")";
    }
}
