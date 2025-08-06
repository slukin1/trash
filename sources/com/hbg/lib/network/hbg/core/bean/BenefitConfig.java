package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class BenefitConfig implements Serializable {
    private int apply;
    private String desc;
    private String icon;

    /* renamed from: id  reason: collision with root package name */
    private int f70225id;
    private String image;
    private List<Integer> levels;
    private int rank;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof BenefitConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BenefitConfig)) {
            return false;
        }
        BenefitConfig benefitConfig = (BenefitConfig) obj;
        if (!benefitConfig.canEqual(this) || getId() != benefitConfig.getId() || getRank() != benefitConfig.getRank() || getType() != benefitConfig.getType()) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = benefitConfig.getDesc();
        if (desc2 != null ? !desc2.equals(desc3) : desc3 != null) {
            return false;
        }
        String icon2 = getIcon();
        String icon3 = benefitConfig.getIcon();
        if (icon2 != null ? !icon2.equals(icon3) : icon3 != null) {
            return false;
        }
        String image2 = getImage();
        String image3 = benefitConfig.getImage();
        if (image2 != null ? !image2.equals(image3) : image3 != null) {
            return false;
        }
        if (getApply() != benefitConfig.getApply()) {
            return false;
        }
        List<Integer> levels2 = getLevels();
        List<Integer> levels3 = benefitConfig.getLevels();
        return levels2 != null ? levels2.equals(levels3) : levels3 == null;
    }

    public int getApply() {
        return this.apply;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.f70225id;
    }

    public String getImage() {
        return this.image;
    }

    public List<Integer> getLevels() {
        return this.levels;
    }

    public int getRank() {
        return this.rank;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int id2 = ((((getId() + 59) * 59) + getRank()) * 59) + getType();
        String desc2 = getDesc();
        int i11 = 43;
        int hashCode = (id2 * 59) + (desc2 == null ? 43 : desc2.hashCode());
        String icon2 = getIcon();
        int hashCode2 = (hashCode * 59) + (icon2 == null ? 43 : icon2.hashCode());
        String image2 = getImage();
        int hashCode3 = (((hashCode2 * 59) + (image2 == null ? 43 : image2.hashCode())) * 59) + getApply();
        List<Integer> levels2 = getLevels();
        int i12 = hashCode3 * 59;
        if (levels2 != null) {
            i11 = levels2.hashCode();
        }
        return i12 + i11;
    }

    public void setApply(int i11) {
        this.apply = i11;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i11) {
        this.f70225id = i11;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setLevels(List<Integer> list) {
        this.levels = list;
    }

    public void setRank(int i11) {
        this.rank = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "BenefitConfig(id=" + getId() + ", rank=" + getRank() + ", type=" + getType() + ", desc=" + getDesc() + ", icon=" + getIcon() + ", image=" + getImage() + ", apply=" + getApply() + ", levels=" + getLevels() + ")";
    }
}
