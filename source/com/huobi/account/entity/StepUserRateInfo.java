package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class StepUserRateInfo implements Serializable {
    public static final String RATE_NORMAL = "";
    public static final String RATE_NORMAL_STEP = "2";
    public static final String RATE_SPECIAL = "0";
    public static final String RATE_SPECIAL_USER_GROUP = "3";
    public static final int SWITCH_OFF = 0;
    public static final int SWITCH_ON = 1;
    private String currency;
    @SerializedName("deduction-switch")
    private int deductionSwitch;
    private String holdings;
    private int level;
    @SerializedName("maker-deduction")
    private String makerDeduction;
    @SerializedName("maker-fee-rate")
    private String makerFeeRate;
    @SerializedName("platform-deduction-switch")
    private int platformDeductionSwitch;
    private String point;
    @SerializedName("point-switch")
    private int pointSwitch;
    @SerializedName("step-rate-type")
    private String stepRateType;
    @SerializedName("taker-deduction")
    private String takerDeduction;
    @SerializedName("taker-fee-rate")
    private String takerFeeRate;
    private String volume;
    @SerializedName("whitelisted-user")
    private boolean whitelistedUser;

    public boolean canEqual(Object obj) {
        return obj instanceof StepUserRateInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StepUserRateInfo)) {
            return false;
        }
        StepUserRateInfo stepUserRateInfo = (StepUserRateInfo) obj;
        if (!stepUserRateInfo.canEqual(this)) {
            return false;
        }
        String holdings2 = getHoldings();
        String holdings3 = stepUserRateInfo.getHoldings();
        if (holdings2 != null ? !holdings2.equals(holdings3) : holdings3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = stepUserRateInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        if (getLevel() != stepUserRateInfo.getLevel()) {
            return false;
        }
        String takerFeeRate2 = getTakerFeeRate();
        String takerFeeRate3 = stepUserRateInfo.getTakerFeeRate();
        if (takerFeeRate2 != null ? !takerFeeRate2.equals(takerFeeRate3) : takerFeeRate3 != null) {
            return false;
        }
        String takerDeduction2 = getTakerDeduction();
        String takerDeduction3 = stepUserRateInfo.getTakerDeduction();
        if (takerDeduction2 != null ? !takerDeduction2.equals(takerDeduction3) : takerDeduction3 != null) {
            return false;
        }
        String makerFeeRate2 = getMakerFeeRate();
        String makerFeeRate3 = stepUserRateInfo.getMakerFeeRate();
        if (makerFeeRate2 != null ? !makerFeeRate2.equals(makerFeeRate3) : makerFeeRate3 != null) {
            return false;
        }
        String makerDeduction2 = getMakerDeduction();
        String makerDeduction3 = stepUserRateInfo.getMakerDeduction();
        if (makerDeduction2 != null ? !makerDeduction2.equals(makerDeduction3) : makerDeduction3 != null) {
            return false;
        }
        String point2 = getPoint();
        String point3 = stepUserRateInfo.getPoint();
        if (point2 != null ? !point2.equals(point3) : point3 != null) {
            return false;
        }
        if (getPointSwitch() != stepUserRateInfo.getPointSwitch() || getDeductionSwitch() != stepUserRateInfo.getDeductionSwitch() || getPlatformDeductionSwitch() != stepUserRateInfo.getPlatformDeductionSwitch()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = stepUserRateInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (isWhitelistedUser() != stepUserRateInfo.isWhitelistedUser()) {
            return false;
        }
        String stepRateType2 = getStepRateType();
        String stepRateType3 = stepUserRateInfo.getStepRateType();
        return stepRateType2 != null ? stepRateType2.equals(stepRateType3) : stepRateType3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getDeductionSwitch() {
        return this.deductionSwitch;
    }

    public String getHoldings() {
        return this.holdings;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMakerDeduction() {
        return this.makerDeduction;
    }

    public String getMakerFeeRate() {
        return this.makerFeeRate;
    }

    public int getPlatformDeductionSwitch() {
        return this.platformDeductionSwitch;
    }

    public String getPoint() {
        return this.point;
    }

    public int getPointSwitch() {
        return this.pointSwitch;
    }

    public String getStepRateType() {
        return this.stepRateType;
    }

    public String getTakerDeduction() {
        return this.takerDeduction;
    }

    public String getTakerFeeRate() {
        return this.takerFeeRate;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String holdings2 = getHoldings();
        int i11 = 43;
        int hashCode = holdings2 == null ? 43 : holdings2.hashCode();
        String volume2 = getVolume();
        int hashCode2 = ((((hashCode + 59) * 59) + (volume2 == null ? 43 : volume2.hashCode())) * 59) + getLevel();
        String takerFeeRate2 = getTakerFeeRate();
        int hashCode3 = (hashCode2 * 59) + (takerFeeRate2 == null ? 43 : takerFeeRate2.hashCode());
        String takerDeduction2 = getTakerDeduction();
        int hashCode4 = (hashCode3 * 59) + (takerDeduction2 == null ? 43 : takerDeduction2.hashCode());
        String makerFeeRate2 = getMakerFeeRate();
        int hashCode5 = (hashCode4 * 59) + (makerFeeRate2 == null ? 43 : makerFeeRate2.hashCode());
        String makerDeduction2 = getMakerDeduction();
        int hashCode6 = (hashCode5 * 59) + (makerDeduction2 == null ? 43 : makerDeduction2.hashCode());
        String point2 = getPoint();
        int hashCode7 = (((((((hashCode6 * 59) + (point2 == null ? 43 : point2.hashCode())) * 59) + getPointSwitch()) * 59) + getDeductionSwitch()) * 59) + getPlatformDeductionSwitch();
        String currency2 = getCurrency();
        int hashCode8 = (((hashCode7 * 59) + (currency2 == null ? 43 : currency2.hashCode())) * 59) + (isWhitelistedUser() ? 79 : 97);
        String stepRateType2 = getStepRateType();
        int i12 = hashCode8 * 59;
        if (stepRateType2 != null) {
            i11 = stepRateType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isHtDeductionOn() {
        if (!"ht".equalsIgnoreCase(getCurrency()) || 1 != getDeductionSwitch()) {
            return false;
        }
        return true;
    }

    public boolean isPointSwitchOn() {
        return getPointSwitch() == 1;
    }

    public boolean isWhitelistedUser() {
        return this.whitelistedUser;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDeductionSwitch(int i11) {
        this.deductionSwitch = i11;
    }

    public void setHoldings(String str) {
        this.holdings = str;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setMakerDeduction(String str) {
        this.makerDeduction = str;
    }

    public void setMakerFeeRate(String str) {
        this.makerFeeRate = str;
    }

    public void setPlatformDeductionSwitch(int i11) {
        this.platformDeductionSwitch = i11;
    }

    public void setPoint(String str) {
        this.point = str;
    }

    public void setPointSwitch(int i11) {
        this.pointSwitch = i11;
    }

    public void setStepRateType(String str) {
        this.stepRateType = str;
    }

    public void setTakerDeduction(String str) {
        this.takerDeduction = str;
    }

    public void setTakerFeeRate(String str) {
        this.takerFeeRate = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public void setWhitelistedUser(boolean z11) {
        this.whitelistedUser = z11;
    }

    public String toString() {
        return "StepUserRateInfo(holdings=" + getHoldings() + ", volume=" + getVolume() + ", level=" + getLevel() + ", takerFeeRate=" + getTakerFeeRate() + ", takerDeduction=" + getTakerDeduction() + ", makerFeeRate=" + getMakerFeeRate() + ", makerDeduction=" + getMakerDeduction() + ", point=" + getPoint() + ", pointSwitch=" + getPointSwitch() + ", deductionSwitch=" + getDeductionSwitch() + ", platformDeductionSwitch=" + getPlatformDeductionSwitch() + ", currency=" + getCurrency() + ", whitelistedUser=" + isWhitelistedUser() + ", stepRateType=" + getStepRateType() + ")";
    }
}
