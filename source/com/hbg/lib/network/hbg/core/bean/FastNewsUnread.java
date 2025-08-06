package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class FastNewsUnread implements Serializable {
    private int num;

    public boolean canEqual(Object obj) {
        return obj instanceof FastNewsUnread;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FastNewsUnread)) {
            return false;
        }
        FastNewsUnread fastNewsUnread = (FastNewsUnread) obj;
        return fastNewsUnread.canEqual(this) && getNum() == fastNewsUnread.getNum();
    }

    public int getNum() {
        return this.num;
    }

    public int hashCode() {
        return 59 + getNum();
    }

    public void setNum(int i11) {
        this.num = i11;
    }

    public String toString() {
        return "FastNewsUnread(num=" + getNum() + ")";
    }
}
