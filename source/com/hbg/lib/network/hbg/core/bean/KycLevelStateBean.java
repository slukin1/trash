package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class KycLevelStateBean implements Serializable {
    private String content;
    private int level;
    private int state;

    public boolean canEqual(Object obj) {
        return obj instanceof KycLevelStateBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KycLevelStateBean)) {
            return false;
        }
        KycLevelStateBean kycLevelStateBean = (KycLevelStateBean) obj;
        if (!kycLevelStateBean.canEqual(this) || getLevel() != kycLevelStateBean.getLevel() || getState() != kycLevelStateBean.getState()) {
            return false;
        }
        String content2 = getContent();
        String content3 = kycLevelStateBean.getContent();
        return content2 != null ? content2.equals(content3) : content3 == null;
    }

    public String getContent() {
        return this.content;
    }

    public int getLevel() {
        return this.level;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        int level2 = ((getLevel() + 59) * 59) + getState();
        String content2 = getContent();
        return (level2 * 59) + (content2 == null ? 43 : content2.hashCode());
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "KycLevelStateBean(level=" + getLevel() + ", state=" + getState() + ", content=" + getContent() + ")";
    }
}
