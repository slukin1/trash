package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class MarginRiskRateBean implements Serializable {
    private String forcedMarginRate;
    private String highRiskMarginRate;
    private String lowRiskMarginRate;
    private String medRiskMarginRate;
    private String minWithdrawalMarginRate;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginRiskRateBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginRiskRateBean)) {
            return false;
        }
        MarginRiskRateBean marginRiskRateBean = (MarginRiskRateBean) obj;
        if (!marginRiskRateBean.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = marginRiskRateBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String minWithdrawalMarginRate2 = getMinWithdrawalMarginRate();
        String minWithdrawalMarginRate3 = marginRiskRateBean.getMinWithdrawalMarginRate();
        if (minWithdrawalMarginRate2 != null ? !minWithdrawalMarginRate2.equals(minWithdrawalMarginRate3) : minWithdrawalMarginRate3 != null) {
            return false;
        }
        String lowRiskMarginRate2 = getLowRiskMarginRate();
        String lowRiskMarginRate3 = marginRiskRateBean.getLowRiskMarginRate();
        if (lowRiskMarginRate2 != null ? !lowRiskMarginRate2.equals(lowRiskMarginRate3) : lowRiskMarginRate3 != null) {
            return false;
        }
        String medRiskMarginRate2 = getMedRiskMarginRate();
        String medRiskMarginRate3 = marginRiskRateBean.getMedRiskMarginRate();
        if (medRiskMarginRate2 != null ? !medRiskMarginRate2.equals(medRiskMarginRate3) : medRiskMarginRate3 != null) {
            return false;
        }
        String highRiskMarginRate2 = getHighRiskMarginRate();
        String highRiskMarginRate3 = marginRiskRateBean.getHighRiskMarginRate();
        if (highRiskMarginRate2 != null ? !highRiskMarginRate2.equals(highRiskMarginRate3) : highRiskMarginRate3 != null) {
            return false;
        }
        String forcedMarginRate2 = getForcedMarginRate();
        String forcedMarginRate3 = marginRiskRateBean.getForcedMarginRate();
        return forcedMarginRate2 != null ? forcedMarginRate2.equals(forcedMarginRate3) : forcedMarginRate3 == null;
    }

    public String getForcedMarginRate() {
        return this.forcedMarginRate;
    }

    public String getHighRiskMarginRate() {
        return this.highRiskMarginRate;
    }

    public String getLowRiskMarginRate() {
        return this.lowRiskMarginRate;
    }

    public String getMedRiskMarginRate() {
        return this.medRiskMarginRate;
    }

    public String getMinWithdrawalMarginRate() {
        return this.minWithdrawalMarginRate;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String minWithdrawalMarginRate2 = getMinWithdrawalMarginRate();
        int hashCode2 = ((hashCode + 59) * 59) + (minWithdrawalMarginRate2 == null ? 43 : minWithdrawalMarginRate2.hashCode());
        String lowRiskMarginRate2 = getLowRiskMarginRate();
        int hashCode3 = (hashCode2 * 59) + (lowRiskMarginRate2 == null ? 43 : lowRiskMarginRate2.hashCode());
        String medRiskMarginRate2 = getMedRiskMarginRate();
        int hashCode4 = (hashCode3 * 59) + (medRiskMarginRate2 == null ? 43 : medRiskMarginRate2.hashCode());
        String highRiskMarginRate2 = getHighRiskMarginRate();
        int hashCode5 = (hashCode4 * 59) + (highRiskMarginRate2 == null ? 43 : highRiskMarginRate2.hashCode());
        String forcedMarginRate2 = getForcedMarginRate();
        int i12 = hashCode5 * 59;
        if (forcedMarginRate2 != null) {
            i11 = forcedMarginRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setForcedMarginRate(String str) {
        this.forcedMarginRate = str;
    }

    public void setHighRiskMarginRate(String str) {
        this.highRiskMarginRate = str;
    }

    public void setLowRiskMarginRate(String str) {
        this.lowRiskMarginRate = str;
    }

    public void setMedRiskMarginRate(String str) {
        this.medRiskMarginRate = str;
    }

    public void setMinWithdrawalMarginRate(String str) {
        this.minWithdrawalMarginRate = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "MarginRiskRateBean(symbol=" + getSymbol() + ", minWithdrawalMarginRate=" + getMinWithdrawalMarginRate() + ", lowRiskMarginRate=" + getLowRiskMarginRate() + ", medRiskMarginRate=" + getMedRiskMarginRate() + ", highRiskMarginRate=" + getHighRiskMarginRate() + ", forcedMarginRate=" + getForcedMarginRate() + ")";
    }
}
