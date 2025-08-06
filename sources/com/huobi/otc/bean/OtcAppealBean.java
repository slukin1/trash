package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcAppealBean implements Serializable {
    private String appealCode;
    private int beforeStatus;
    private String description;
    private boolean isCancle;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcAppealBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcAppealBean)) {
            return false;
        }
        OtcAppealBean otcAppealBean = (OtcAppealBean) obj;
        if (!otcAppealBean.canEqual(this)) {
            return false;
        }
        String appealCode2 = getAppealCode();
        String appealCode3 = otcAppealBean.getAppealCode();
        if (appealCode2 != null ? !appealCode2.equals(appealCode3) : appealCode3 != null) {
            return false;
        }
        if (isCancle() != otcAppealBean.isCancle() || getType() != otcAppealBean.getType()) {
            return false;
        }
        String description2 = getDescription();
        String description3 = otcAppealBean.getDescription();
        if (description2 != null ? description2.equals(description3) : description3 == null) {
            return getBeforeStatus() == otcAppealBean.getBeforeStatus();
        }
        return false;
    }

    public String getAppealCode() {
        return this.appealCode;
    }

    public int getBeforeStatus() {
        return this.beforeStatus;
    }

    public String getDescription() {
        return this.description;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String appealCode2 = getAppealCode();
        int i11 = 43;
        int hashCode = (((((appealCode2 == null ? 43 : appealCode2.hashCode()) + 59) * 59) + (isCancle() ? 79 : 97)) * 59) + getType();
        String description2 = getDescription();
        int i12 = hashCode * 59;
        if (description2 != null) {
            i11 = description2.hashCode();
        }
        return ((i12 + i11) * 59) + getBeforeStatus();
    }

    public boolean isCancle() {
        return this.isCancle;
    }

    public void setAppealCode(String str) {
        this.appealCode = str;
    }

    public void setBeforeStatus(int i11) {
        this.beforeStatus = i11;
    }

    public void setCancle(boolean z11) {
        this.isCancle = z11;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "OtcAppealBean(appealCode=" + getAppealCode() + ", isCancle=" + isCancle() + ", type=" + getType() + ", description=" + getDescription() + ", beforeStatus=" + getBeforeStatus() + ")";
    }
}
