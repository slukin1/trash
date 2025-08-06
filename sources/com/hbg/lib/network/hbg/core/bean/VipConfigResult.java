package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.VipLevel;
import java.io.Serializable;
import java.util.List;

public class VipConfigResult implements Serializable {
    private String base;
    private List<BenefitConfig> benefits;
    private List<VipLevel> levels;

    public boolean canEqual(Object obj) {
        return obj instanceof VipConfigResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VipConfigResult)) {
            return false;
        }
        VipConfigResult vipConfigResult = (VipConfigResult) obj;
        if (!vipConfigResult.canEqual(this)) {
            return false;
        }
        String base2 = getBase();
        String base3 = vipConfigResult.getBase();
        if (base2 != null ? !base2.equals(base3) : base3 != null) {
            return false;
        }
        List<BenefitConfig> benefits2 = getBenefits();
        List<BenefitConfig> benefits3 = vipConfigResult.getBenefits();
        if (benefits2 != null ? !benefits2.equals(benefits3) : benefits3 != null) {
            return false;
        }
        List<VipLevel> levels2 = getLevels();
        List<VipLevel> levels3 = vipConfigResult.getLevels();
        return levels2 != null ? levels2.equals(levels3) : levels3 == null;
    }

    public String getBase() {
        return this.base;
    }

    public List<BenefitConfig> getBenefits() {
        return this.benefits;
    }

    public List<VipLevel> getLevels() {
        return this.levels;
    }

    public int hashCode() {
        String base2 = getBase();
        int i11 = 43;
        int hashCode = base2 == null ? 43 : base2.hashCode();
        List<BenefitConfig> benefits2 = getBenefits();
        int hashCode2 = ((hashCode + 59) * 59) + (benefits2 == null ? 43 : benefits2.hashCode());
        List<VipLevel> levels2 = getLevels();
        int i12 = hashCode2 * 59;
        if (levels2 != null) {
            i11 = levels2.hashCode();
        }
        return i12 + i11;
    }

    public void setBase(String str) {
        this.base = str;
    }

    public void setBenefits(List<BenefitConfig> list) {
        this.benefits = list;
    }

    public void setLevels(List<VipLevel> list) {
        this.levels = list;
    }

    public String toString() {
        return "VipConfigResult(base=" + getBase() + ", benefits=" + getBenefits() + ", levels=" + getLevels() + ")";
    }
}
