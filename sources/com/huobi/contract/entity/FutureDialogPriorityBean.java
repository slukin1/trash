package com.huobi.contract.entity;

import java.io.Serializable;

public class FutureDialogPriorityBean implements Serializable {
    public static final int SHOW_STATUS_NOT_SHOW = 1;
    public static final int SHOW_STATUS_SHOWED = 3;
    public static final int SHOW_STATUS_SHOWING = 2;
    private static final long serialVersionUID = 1309806851018891190L;
    private boolean loginShow;
    private String name;
    private boolean showAways;
    private int showLever;
    private int showStatus;

    public FutureDialogPriorityBean(String str, int i11, boolean z11, int i12, boolean z12) {
        this.name = str;
        this.showStatus = i11;
        this.showAways = z11;
        this.showLever = i12;
        this.loginShow = z12;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof FutureDialogPriorityBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureDialogPriorityBean)) {
            return false;
        }
        FutureDialogPriorityBean futureDialogPriorityBean = (FutureDialogPriorityBean) obj;
        if (!futureDialogPriorityBean.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = futureDialogPriorityBean.getName();
        if (name2 != null ? name2.equals(name3) : name3 == null) {
            return getShowStatus() == futureDialogPriorityBean.getShowStatus() && isShowAways() == futureDialogPriorityBean.isShowAways() && getShowLever() == futureDialogPriorityBean.getShowLever() && isLoginShow() == futureDialogPriorityBean.isLoginShow();
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getShowLever() {
        return this.showLever;
    }

    public int getShowStatus() {
        return this.showStatus;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 79;
        int hashCode = ((((((((name2 == null ? 43 : name2.hashCode()) + 59) * 59) + getShowStatus()) * 59) + (isShowAways() ? 79 : 97)) * 59) + getShowLever()) * 59;
        if (!isLoginShow()) {
            i11 = 97;
        }
        return hashCode + i11;
    }

    public boolean isLoginShow() {
        return this.loginShow;
    }

    public boolean isNotShow() {
        return this.showStatus == 1;
    }

    public boolean isNotShowOrShowing() {
        return isNotShow() || isShowIng();
    }

    public boolean isShowAways() {
        return this.showAways;
    }

    public boolean isShowIng() {
        return this.showStatus == 2;
    }

    public boolean isShowed() {
        return this.showStatus == 3;
    }

    public void setLoginShow(boolean z11) {
        this.loginShow = z11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShowAways(boolean z11) {
        this.showAways = z11;
    }

    public void setShowLever(int i11) {
        this.showLever = i11;
    }

    public void setShowStatus(int i11) {
        this.showStatus = i11;
    }

    public String toString() {
        return "FutureDialogPriorityBean(name=" + getName() + ", showStatus=" + getShowStatus() + ", showAways=" + isShowAways() + ", showLever=" + getShowLever() + ", loginShow=" + isLoginShow() + ")";
    }
}
