package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionCancelErrorInfo implements Serializable {
    private static final long serialVersionUID = -8723262099154134122L;
    @SerializedName("err_code")
    private String errCode;
    @SerializedName("err_msg")
    private String errMsg;
    @SerializedName("order_id")
    private String orderId;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionCancelErrorInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionCancelErrorInfo)) {
            return false;
        }
        OptionCancelErrorInfo optionCancelErrorInfo = (OptionCancelErrorInfo) obj;
        if (!optionCancelErrorInfo.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = optionCancelErrorInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String errCode2 = getErrCode();
        String errCode3 = optionCancelErrorInfo.getErrCode();
        if (errCode2 != null ? !errCode2.equals(errCode3) : errCode3 != null) {
            return false;
        }
        String errMsg2 = getErrMsg();
        String errMsg3 = optionCancelErrorInfo.getErrMsg();
        return errMsg2 != null ? errMsg2.equals(errMsg3) : errMsg3 == null;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String errCode2 = getErrCode();
        int hashCode2 = ((hashCode + 59) * 59) + (errCode2 == null ? 43 : errCode2.hashCode());
        String errMsg2 = getErrMsg();
        int i12 = hashCode2 * 59;
        if (errMsg2 != null) {
            i11 = errMsg2.hashCode();
        }
        return i12 + i11;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String toString() {
        return "OptionCancelErrorInfo(orderId=" + getOrderId() + ", errCode=" + getErrCode() + ", errMsg=" + getErrMsg() + ")";
    }
}
