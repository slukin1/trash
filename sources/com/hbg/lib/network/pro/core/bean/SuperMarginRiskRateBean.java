package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class SuperMarginRiskRateBean implements Serializable {
    private String currency;
    private String forcedMarginRate;
    private String highRiskMarginRate;
    private String lowRiskMarginRate;
    private String medRiskMarginRate;
    private String minWithdrawalMarginRate;

    public boolean canEqual(Object obj) {
        return obj instanceof SuperMarginRiskRateBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SuperMarginRiskRateBean)) {
            return false;
        }
        SuperMarginRiskRateBean superMarginRiskRateBean = (SuperMarginRiskRateBean) obj;
        if (!superMarginRiskRateBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = superMarginRiskRateBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String minWithdrawalMarginRate2 = getMinWithdrawalMarginRate();
        String minWithdrawalMarginRate3 = superMarginRiskRateBean.getMinWithdrawalMarginRate();
        if (minWithdrawalMarginRate2 != null ? !minWithdrawalMarginRate2.equals(minWithdrawalMarginRate3) : minWithdrawalMarginRate3 != null) {
            return false;
        }
        String lowRiskMarginRate2 = getLowRiskMarginRate();
        String lowRiskMarginRate3 = superMarginRiskRateBean.getLowRiskMarginRate();
        if (lowRiskMarginRate2 != null ? !lowRiskMarginRate2.equals(lowRiskMarginRate3) : lowRiskMarginRate3 != null) {
            return false;
        }
        String medRiskMarginRate2 = getMedRiskMarginRate();
        String medRiskMarginRate3 = superMarginRiskRateBean.getMedRiskMarginRate();
        if (medRiskMarginRate2 != null ? !medRiskMarginRate2.equals(medRiskMarginRate3) : medRiskMarginRate3 != null) {
            return false;
        }
        String highRiskMarginRate2 = getHighRiskMarginRate();
        String highRiskMarginRate3 = superMarginRiskRateBean.getHighRiskMarginRate();
        if (highRiskMarginRate2 != null ? !highRiskMarginRate2.equals(highRiskMarginRate3) : highRiskMarginRate3 != null) {
            return false;
        }
        String forcedMarginRate2 = getForcedMarginRate();
        String forcedMarginRate3 = superMarginRiskRateBean.getForcedMarginRate();
        return forcedMarginRate2 != null ? forcedMarginRate2.equals(forcedMarginRate3) : forcedMarginRate3 == null;
    }

    public String getCurrency() {
        return this.currency;
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

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
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

    public void setCurrency(String str) {
        this.currency = str;
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

    public String toString() {
        return "SuperMarginRiskRateBean(currency=" + getCurrency() + ", minWithdrawalMarginRate=" + getMinWithdrawalMarginRate() + ", lowRiskMarginRate=" + getLowRiskMarginRate() + ", medRiskMarginRate=" + getMedRiskMarginRate() + ", highRiskMarginRate=" + getHighRiskMarginRate() + ", forcedMarginRate=" + getForcedMarginRate() + ")";
    }
}
