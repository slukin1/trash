package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class BenefitListData implements Serializable {
    private List<VipBenefitStatus> benefits;
    private long expiredAt;
    private int level;
    private int score;

    public boolean canEqual(Object obj) {
        return obj instanceof BenefitListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BenefitListData)) {
            return false;
        }
        BenefitListData benefitListData = (BenefitListData) obj;
        if (!benefitListData.canEqual(this) || getLevel() != benefitListData.getLevel() || getScore() != benefitListData.getScore() || getExpiredAt() != benefitListData.getExpiredAt()) {
            return false;
        }
        List<VipBenefitStatus> benefits2 = getBenefits();
        List<VipBenefitStatus> benefits3 = benefitListData.getBenefits();
        return benefits2 != null ? benefits2.equals(benefits3) : benefits3 == null;
    }

    public List<VipBenefitStatus> getBenefits() {
        return this.benefits;
    }

    public long getExpiredAt() {
        return this.expiredAt;
    }

    public int getLevel() {
        return this.level;
    }

    public int getScore() {
        return this.score;
    }

    public int hashCode() {
        int level2 = ((getLevel() + 59) * 59) + getScore();
        long expiredAt2 = getExpiredAt();
        int i11 = (level2 * 59) + ((int) (expiredAt2 ^ (expiredAt2 >>> 32)));
        List<VipBenefitStatus> benefits2 = getBenefits();
        return (i11 * 59) + (benefits2 == null ? 43 : benefits2.hashCode());
    }

    public void setBenefits(List<VipBenefitStatus> list) {
        this.benefits = list;
    }

    public void setExpiredAt(long j11) {
        this.expiredAt = j11;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setScore(int i11) {
        this.score = i11;
    }

    public String toString() {
        return "BenefitListData(level=" + getLevel() + ", score=" + getScore() + ", expiredAt=" + getExpiredAt() + ", benefits=" + getBenefits() + ")";
    }
}
