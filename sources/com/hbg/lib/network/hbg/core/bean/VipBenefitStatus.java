package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class VipBenefitStatus implements Serializable {
    public static final int STATE_APPLY_IN_PROGRESS = 1;
    private int benefitId;
    private int state;

    public boolean canEqual(Object obj) {
        return obj instanceof VipBenefitStatus;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VipBenefitStatus)) {
            return false;
        }
        VipBenefitStatus vipBenefitStatus = (VipBenefitStatus) obj;
        return vipBenefitStatus.canEqual(this) && getBenefitId() == vipBenefitStatus.getBenefitId() && getState() == vipBenefitStatus.getState();
    }

    public int getBenefitId() {
        return this.benefitId;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        return ((getBenefitId() + 59) * 59) + getState();
    }

    public void setBenefitId(int i11) {
        this.benefitId = i11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "VipBenefitStatus(benefitId=" + getBenefitId() + ", state=" + getState() + ")";
    }
}
