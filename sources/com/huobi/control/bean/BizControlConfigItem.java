package com.huobi.control.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BizControlConfigItem implements Serializable {
    private static final long serialVersionUID = -7273205210419244169L;
    @SerializedName("code")
    private int code;
    @SerializedName("state")
    private String state;

    public BizControlConfigItem() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof BizControlConfigItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BizControlConfigItem)) {
            return false;
        }
        BizControlConfigItem bizControlConfigItem = (BizControlConfigItem) obj;
        if (!bizControlConfigItem.canEqual(this) || getCode() != bizControlConfigItem.getCode()) {
            return false;
        }
        String state2 = getState();
        String state3 = bizControlConfigItem.getState();
        return state2 != null ? state2.equals(state3) : state3 == null;
    }

    public int getCode() {
        return this.code;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        String state2 = getState();
        return ((getCode() + 59) * 59) + (state2 == null ? 43 : state2.hashCode());
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "BizControlConfigItem(code=" + getCode() + ", state=" + getState() + ")";
    }

    public BizControlConfigItem(int i11, String str) {
        this.code = i11;
        this.state = str;
    }
}
