package com.hbg.lib.network.hbg.otcoptions;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PreVisibleBean implements Serializable {
    @SerializedName("err-msg")
    private String errMsg;
    private boolean visible;

    public boolean canEqual(Object obj) {
        return obj instanceof PreVisibleBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreVisibleBean)) {
            return false;
        }
        PreVisibleBean preVisibleBean = (PreVisibleBean) obj;
        if (!preVisibleBean.canEqual(this)) {
            return false;
        }
        String errMsg2 = getErrMsg();
        String errMsg3 = preVisibleBean.getErrMsg();
        if (errMsg2 != null ? errMsg2.equals(errMsg3) : errMsg3 == null) {
            return isVisible() == preVisibleBean.isVisible();
        }
        return false;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int hashCode() {
        String errMsg2 = getErrMsg();
        return (((errMsg2 == null ? 43 : errMsg2.hashCode()) + 59) * 59) + (isVisible() ? 79 : 97);
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setVisible(boolean z11) {
        this.visible = z11;
    }

    public String toString() {
        return "PreVisibleBean(errMsg=" + getErrMsg() + ", visible=" + isVisible() + ")";
    }
}
