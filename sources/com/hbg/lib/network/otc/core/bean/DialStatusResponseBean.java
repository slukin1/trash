package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class DialStatusResponseBean implements Serializable {
    public static final int STATE_CALLING = 2;
    public static final int STATE_NO_CALL = 1;
    public static final int VOICE_TYPE_1 = 1;
    public static final int VOICE_TYPE_2 = 2;
    private int state = 1;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof DialStatusResponseBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DialStatusResponseBean)) {
            return false;
        }
        DialStatusResponseBean dialStatusResponseBean = (DialStatusResponseBean) obj;
        return dialStatusResponseBean.canEqual(this) && getState() == dialStatusResponseBean.getState() && getType() == dialStatusResponseBean.getType();
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return ((getState() + 59) * 59) + getType();
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "DialStatusResponseBean(state=" + getState() + ", type=" + getType() + ")";
    }
}
