package com.hbg.lib.imsdk;

import java.io.Serializable;

public class HbgDialogPageBean implements Serializable {
    private static final long serialVersionUID = 1305610690279848411L;
    public boolean isActivity;
    public String name;

    public HbgDialogPageBean(String str, boolean z11) {
        this.name = str;
        this.isActivity = z11;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HbgDialogPageBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgDialogPageBean)) {
            return false;
        }
        HbgDialogPageBean hbgDialogPageBean = (HbgDialogPageBean) obj;
        if (!hbgDialogPageBean.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = hbgDialogPageBean.getName();
        if (name2 != null ? name2.equals(name3) : name3 == null) {
            return isActivity() == hbgDialogPageBean.isActivity();
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String name2 = getName();
        return (((name2 == null ? 43 : name2.hashCode()) + 59) * 59) + (isActivity() ? 79 : 97);
    }

    public boolean isActivity() {
        return this.isActivity;
    }

    public void setActivity(boolean z11) {
        this.isActivity = z11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "HbgDialogPageBean(name=" + getName() + ", isActivity=" + isActivity() + ")";
    }
}
