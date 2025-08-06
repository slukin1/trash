package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class RankLabelBean implements Serializable {
    private static final long serialVersionUID = 8819566427318749445L;
    private String titleName;
    private int titleProperty;

    public boolean canEqual(Object obj) {
        return obj instanceof RankLabelBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankLabelBean)) {
            return false;
        }
        RankLabelBean rankLabelBean = (RankLabelBean) obj;
        if (!rankLabelBean.canEqual(this)) {
            return false;
        }
        String titleName2 = getTitleName();
        String titleName3 = rankLabelBean.getTitleName();
        if (titleName2 != null ? titleName2.equals(titleName3) : titleName3 == null) {
            return getTitleProperty() == rankLabelBean.getTitleProperty();
        }
        return false;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public int getTitleProperty() {
        return this.titleProperty;
    }

    public int hashCode() {
        String titleName2 = getTitleName();
        return (((titleName2 == null ? 43 : titleName2.hashCode()) + 59) * 59) + getTitleProperty();
    }

    public void setTitleName(String str) {
        this.titleName = str;
    }

    public void setTitleProperty(int i11) {
        this.titleProperty = i11;
    }

    public String toString() {
        return "RankLabelBean(titleName=" + getTitleName() + ", titleProperty=" + getTitleProperty() + ")";
    }
}
