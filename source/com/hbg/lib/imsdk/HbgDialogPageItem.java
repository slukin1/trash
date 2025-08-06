package com.hbg.lib.imsdk;

import java.io.Serializable;

public class HbgDialogPageItem implements Serializable {
    private String className;
    private boolean isViewCreate;

    public boolean canEqual(Object obj) {
        return obj instanceof HbgDialogPageItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgDialogPageItem)) {
            return false;
        }
        HbgDialogPageItem hbgDialogPageItem = (HbgDialogPageItem) obj;
        if (!hbgDialogPageItem.canEqual(this)) {
            return false;
        }
        String className2 = getClassName();
        String className3 = hbgDialogPageItem.getClassName();
        if (className2 != null ? className2.equals(className3) : className3 == null) {
            return isViewCreate() == hbgDialogPageItem.isViewCreate();
        }
        return false;
    }

    public String getClassName() {
        return this.className;
    }

    public int hashCode() {
        String className2 = getClassName();
        return (((className2 == null ? 43 : className2.hashCode()) + 59) * 59) + (isViewCreate() ? 79 : 97);
    }

    public boolean isViewCreate() {
        return this.isViewCreate;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setViewCreate(boolean z11) {
        this.isViewCreate = z11;
    }

    public String toString() {
        return "HbgDialogPageItem(className=" + getClassName() + ", isViewCreate=" + isViewCreate() + ")";
    }
}
