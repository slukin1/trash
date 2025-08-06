package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UserStepRateLevelsInfo implements Serializable {
    private static final long serialVersionUID = 3917563910569622965L;
    private DeductionDetail deductionDetail;
    private FeeRateDetail feeRateDetail;
    private String holdings;
    private LendingDetail lendingDetail;
    private int level;
    private int type;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof UserStepRateLevelsInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserStepRateLevelsInfo)) {
            return false;
        }
        UserStepRateLevelsInfo userStepRateLevelsInfo = (UserStepRateLevelsInfo) obj;
        if (!userStepRateLevelsInfo.canEqual(this) || getLevel() != userStepRateLevelsInfo.getLevel() || getType() != userStepRateLevelsInfo.getType()) {
            return false;
        }
        String holdings2 = getHoldings();
        String holdings3 = userStepRateLevelsInfo.getHoldings();
        if (holdings2 != null ? !holdings2.equals(holdings3) : holdings3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = userStepRateLevelsInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        FeeRateDetail feeRateDetail2 = getFeeRateDetail();
        FeeRateDetail feeRateDetail3 = userStepRateLevelsInfo.getFeeRateDetail();
        if (feeRateDetail2 != null ? !feeRateDetail2.equals(feeRateDetail3) : feeRateDetail3 != null) {
            return false;
        }
        LendingDetail lendingDetail2 = getLendingDetail();
        LendingDetail lendingDetail3 = userStepRateLevelsInfo.getLendingDetail();
        if (lendingDetail2 != null ? !lendingDetail2.equals(lendingDetail3) : lendingDetail3 != null) {
            return false;
        }
        DeductionDetail deductionDetail2 = getDeductionDetail();
        DeductionDetail deductionDetail3 = userStepRateLevelsInfo.getDeductionDetail();
        return deductionDetail2 != null ? deductionDetail2.equals(deductionDetail3) : deductionDetail3 == null;
    }

    public DeductionDetail getDeductionDetail() {
        return this.deductionDetail;
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

    public int getType() {
        return this.type;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int level2 = ((getLevel() + 59) * 59) + getType();
        String holdings2 = getHoldings();
        int i11 = 43;
        int hashCode = (level2 * 59) + (holdings2 == null ? 43 : holdings2.hashCode());
        String volume2 = getVolume();
        int hashCode2 = (hashCode * 59) + (volume2 == null ? 43 : volume2.hashCode());
        FeeRateDetail feeRateDetail2 = getFeeRateDetail();
        int hashCode3 = (hashCode2 * 59) + (feeRateDetail2 == null ? 43 : feeRateDetail2.hashCode());
        LendingDetail lendingDetail2 = getLendingDetail();
        int hashCode4 = (hashCode3 * 59) + (lendingDetail2 == null ? 43 : lendingDetail2.hashCode());
        DeductionDetail deductionDetail2 = getDeductionDetail();
        int i12 = hashCode4 * 59;
        if (deductionDetail2 != null) {
            i11 = deductionDetail2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isProfesssional() {
        FeeRateDetail feeRateDetail2 = this.feeRateDetail;
        if (feeRateDetail2 == null || !"0".equals(feeRateDetail2.getTakerDeduction()) || !"0".equals(this.feeRateDetail.getMakerDeduction())) {
            return false;
        }
        return true;
    }

    public void setDeductionDetail(DeductionDetail deductionDetail2) {
        this.deductionDetail = deductionDetail2;
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

    public void setType(int i11) {
        this.type = i11;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "UserStepRateLevelsInfo(level=" + getLevel() + ", type=" + getType() + ", holdings=" + getHoldings() + ", volume=" + getVolume() + ", feeRateDetail=" + getFeeRateDetail() + ", lendingDetail=" + getLendingDetail() + ", deductionDetail=" + getDeductionDetail() + ")";
    }
}
