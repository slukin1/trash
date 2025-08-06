package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class UserVerifyWaysBean implements Serializable {
    private boolean isGaOpened;
    private boolean isMailOpened;
    private boolean isPhoneOpened;
    private boolean isTradeBind;
    private int ucGaStatus;
    private int ucMailStatus;
    private int ucPhoneStatus;

    public boolean canEqual(Object obj) {
        return obj instanceof UserVerifyWaysBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserVerifyWaysBean)) {
            return false;
        }
        UserVerifyWaysBean userVerifyWaysBean = (UserVerifyWaysBean) obj;
        return userVerifyWaysBean.canEqual(this) && isTradeBind() == userVerifyWaysBean.isTradeBind() && isPhoneOpened() == userVerifyWaysBean.isPhoneOpened() && isMailOpened() == userVerifyWaysBean.isMailOpened() && isGaOpened() == userVerifyWaysBean.isGaOpened() && getUcPhoneStatus() == userVerifyWaysBean.getUcPhoneStatus() && getUcMailStatus() == userVerifyWaysBean.getUcMailStatus() && getUcGaStatus() == userVerifyWaysBean.getUcGaStatus();
    }

    public int getUcGaStatus() {
        return this.ucGaStatus;
    }

    public int getUcMailStatus() {
        return this.ucMailStatus;
    }

    public int getUcPhoneStatus() {
        return this.ucPhoneStatus;
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = ((((((isTradeBind() ? 79 : 97) + 59) * 59) + (isPhoneOpened() ? 79 : 97)) * 59) + (isMailOpened() ? 79 : 97)) * 59;
        if (!isGaOpened()) {
            i11 = 97;
        }
        return ((((((i12 + i11) * 59) + getUcPhoneStatus()) * 59) + getUcMailStatus()) * 59) + getUcGaStatus();
    }

    public boolean isGaOpened() {
        return this.isGaOpened;
    }

    public boolean isMailOpened() {
        return this.isMailOpened;
    }

    public boolean isPhoneOpened() {
        return this.isPhoneOpened;
    }

    public boolean isTradeBind() {
        return this.isTradeBind;
    }

    public void setGaOpened(boolean z11) {
        this.isGaOpened = z11;
    }

    public void setMailOpened(boolean z11) {
        this.isMailOpened = z11;
    }

    public void setPhoneOpened(boolean z11) {
        this.isPhoneOpened = z11;
    }

    public void setTradeBind(boolean z11) {
        this.isTradeBind = z11;
    }

    public void setUcGaStatus(int i11) {
        this.ucGaStatus = i11;
    }

    public void setUcMailStatus(int i11) {
        this.ucMailStatus = i11;
    }

    public void setUcPhoneStatus(int i11) {
        this.ucPhoneStatus = i11;
    }

    public String toString() {
        return "UserVerifyWaysBean(isTradeBind=" + isTradeBind() + ", isPhoneOpened=" + isPhoneOpened() + ", isMailOpened=" + isMailOpened() + ", isGaOpened=" + isGaOpened() + ", ucPhoneStatus=" + getUcPhoneStatus() + ", ucMailStatus=" + getUcMailStatus() + ", ucGaStatus=" + getUcGaStatus() + ")";
    }
}
