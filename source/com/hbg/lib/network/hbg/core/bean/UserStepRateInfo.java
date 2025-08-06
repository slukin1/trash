package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserStepRateInfo implements Serializable {
    public static final String RATE_NORMAL = "";
    public static final String RATE_NORMAL_STEP = "2";
    public static final String RATE_SPECIAL = "0";
    public static final String RATE_SPECIAL_USER_GROUP = "3";
    public static final int SWITCH_OFF = 0;
    public static final int SWITCH_ON = 1;
    private static final long serialVersionUID = 3917563910569622965L;
    private String currency;
    private DeductionDetail deductionDetail;
    private int deductionSwitch;
    private FeeRateDetail feeRateDetail;
    private String holdings;
    private LendingDetail lendingDetail;
    private int level;
    private int platformDeductionSwitch;
    private int pointSwitch;
    private String stepRateType;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof UserStepRateInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserStepRateInfo)) {
            return false;
        }
        UserStepRateInfo userStepRateInfo = (UserStepRateInfo) obj;
        if (!userStepRateInfo.canEqual(this)) {
            return false;
        }
        String holdings2 = getHoldings();
        String holdings3 = userStepRateInfo.getHoldings();
        if (holdings2 != null ? !holdings2.equals(holdings3) : holdings3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = userStepRateInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        if (getLevel() != userStepRateInfo.getLevel()) {
            return false;
        }
        FeeRateDetail feeRateDetail2 = getFeeRateDetail();
        FeeRateDetail feeRateDetail3 = userStepRateInfo.getFeeRateDetail();
        if (feeRateDetail2 != null ? !feeRateDetail2.equals(feeRateDetail3) : feeRateDetail3 != null) {
            return false;
        }
        LendingDetail lendingDetail2 = getLendingDetail();
        LendingDetail lendingDetail3 = userStepRateInfo.getLendingDetail();
        if (lendingDetail2 != null ? !lendingDetail2.equals(lendingDetail3) : lendingDetail3 != null) {
            return false;
        }
        DeductionDetail deductionDetail2 = getDeductionDetail();
        DeductionDetail deductionDetail3 = userStepRateInfo.getDeductionDetail();
        if (deductionDetail2 != null ? !deductionDetail2.equals(deductionDetail3) : deductionDetail3 != null) {
            return false;
        }
        if (getPointSwitch() != userStepRateInfo.getPointSwitch() || getDeductionSwitch() != userStepRateInfo.getDeductionSwitch() || getPlatformDeductionSwitch() != userStepRateInfo.getPlatformDeductionSwitch()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = userStepRateInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String stepRateType2 = getStepRateType();
        String stepRateType3 = userStepRateInfo.getStepRateType();
        return stepRateType2 != null ? stepRateType2.equals(stepRateType3) : stepRateType3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public DeductionDetail getDeductionDetail() {
        return this.deductionDetail;
    }

    public int getDeductionSwitch() {
        return this.deductionSwitch;
    }

    public FeeRateDetail getFeeRateDetail() {
        return this.feeRateDetail;
    }

    public String getHoldings() {
        return this.holdings;
    }

    public LendingDetail getLendingDetail() {
        return this.lendingDetail;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMakerDeduction() {
        FeeRateDetail feeRateDetail2 = this.feeRateDetail;
        if (feeRateDetail2 != null) {
            return feeRateDetail2.getMakerDeduction();
        }
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getMakerDeduction() : "";
    }

    public String getMakerFeeRate() {
        FeeRateDetail feeRateDetail2 = this.feeRateDetail;
        if (feeRateDetail2 != null) {
            return feeRateDetail2.getMakerFeeRate();
        }
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getMakerFeeRate() : "";
    }

    public String getMarginDeduction() {
        LendingDetail lendingDetail2 = this.lendingDetail;
        return lendingDetail2 != null ? lendingDetail2.getDeduction() : "";
    }

    public String getMarginRate() {
        LendingDetail lendingDetail2 = this.lendingDetail;
        return lendingDetail2 != null ? lendingDetail2.getLendingRate() : "";
    }

    public String getOtcMakerDeduction() {
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getMakerDeduction() : "";
    }

    public String getOtcMakerFeeRate() {
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getMakerFeeRate() : "";
    }

    public String getOtcTakerDeduction() {
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getTakerDeduction() : "";
    }

    public String getOtcTakerFeeRate() {
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getTakerFeeRate() : "";
    }

    public int getPlatformDeductionSwitch() {
        return this.platformDeductionSwitch;
    }

    public int getPointSwitch() {
        return this.pointSwitch;
    }

    public String getStepRateType() {
        return this.stepRateType;
    }

    public String getTakerDeduction() {
        FeeRateDetail feeRateDetail2 = this.feeRateDetail;
        if (feeRateDetail2 != null) {
            return feeRateDetail2.getTakerDeduction();
        }
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getTakerDeduction() : "";
    }

    public String getTakerFeeRate() {
        FeeRateDetail feeRateDetail2 = this.feeRateDetail;
        if (feeRateDetail2 != null) {
            return feeRateDetail2.getTakerFeeRate();
        }
        DeductionDetail deductionDetail2 = this.deductionDetail;
        return deductionDetail2 != null ? deductionDetail2.getTakerFeeRate() : "";
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
        FeeRateDetail feeRateDetail2 = getFeeRateDetail();
        int hashCode3 = (hashCode2 * 59) + (feeRateDetail2 == null ? 43 : feeRateDetail2.hashCode());
        LendingDetail lendingDetail2 = getLendingDetail();
        int hashCode4 = (hashCode3 * 59) + (lendingDetail2 == null ? 43 : lendingDetail2.hashCode());
        DeductionDetail deductionDetail2 = getDeductionDetail();
        int hashCode5 = (((((((hashCode4 * 59) + (deductionDetail2 == null ? 43 : deductionDetail2.hashCode())) * 59) + getPointSwitch()) * 59) + getDeductionSwitch()) * 59) + getPlatformDeductionSwitch();
        String currency2 = getCurrency();
        int hashCode6 = (hashCode5 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String stepRateType2 = getStepRateType();
        int i12 = hashCode6 * 59;
        if (stepRateType2 != null) {
            i11 = stepRateType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isHtDeductionOn(String str) {
        return str.equalsIgnoreCase(getCurrency()) && 1 == getDeductionSwitch();
    }

    public boolean isPointSwitchOn() {
        return getPointSwitch() == 1;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDeductionDetail(DeductionDetail deductionDetail2) {
        this.deductionDetail = deductionDetail2;
    }

    public void setDeductionSwitch(int i11) {
        this.deductionSwitch = i11;
    }

    public void setFeeRateDetail(FeeRateDetail feeRateDetail2) {
        this.feeRateDetail = feeRateDetail2;
    }

    public void setHoldings(String str) {
        this.holdings = str;
    }

    public void setLendingDetail(LendingDetail lendingDetail2) {
        this.lendingDetail = lendingDetail2;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setPlatformDeductionSwitch(int i11) {
        this.platformDeductionSwitch = i11;
    }

    public void setPointSwitch(int i11) {
        this.pointSwitch = i11;
    }

    public void setStepRateType(String str) {
        this.stepRateType = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "UserStepRateInfo(holdings=" + getHoldings() + ", volume=" + getVolume() + ", level=" + getLevel() + ", feeRateDetail=" + getFeeRateDetail() + ", lendingDetail=" + getLendingDetail() + ", deductionDetail=" + getDeductionDetail() + ", pointSwitch=" + getPointSwitch() + ", deductionSwitch=" + getDeductionSwitch() + ", platformDeductionSwitch=" + getPlatformDeductionSwitch() + ", currency=" + getCurrency() + ", stepRateType=" + getStepRateType() + ")";
    }
}
