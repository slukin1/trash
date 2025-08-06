package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapOrderErrorInfo implements Serializable {
    private static final long serialVersionUID = -7907022809063811419L;
    @SerializedName("client_order_id")
    private int clientOrderId;
    @SerializedName("err_code")
    private int errCode;
    @SerializedName("err_msg")
    private String errMsg;
    @SerializedName("order_id")
    private long orderId;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapOrderErrorInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapOrderErrorInfo)) {
            return false;
        }
        LinearSwapOrderErrorInfo linearSwapOrderErrorInfo = (LinearSwapOrderErrorInfo) obj;
        if (!linearSwapOrderErrorInfo.canEqual(this) || getOrderId() != linearSwapOrderErrorInfo.getOrderId() || getClientOrderId() != linearSwapOrderErrorInfo.getClientOrderId() || getErrCode() != linearSwapOrderErrorInfo.getErrCode()) {
            return false;
        }
        String errMsg2 = getErrMsg();
        String errMsg3 = linearSwapOrderErrorInfo.getErrMsg();
        return errMsg2 != null ? errMsg2.equals(errMsg3) : errMsg3 == null;
    }

    public int getClientOrderId() {
        return this.clientOrderId;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        long orderId2 = getOrderId();
        int clientOrderId2 = ((((((int) (orderId2 ^ (orderId2 >>> 32))) + 59) * 59) + getClientOrderId()) * 59) + getErrCode();
        String errMsg2 = getErrMsg();
        return (clientOrderId2 * 59) + (errMsg2 == null ? 43 : errMsg2.hashCode());
    }

    public void setClientOrderId(int i11) {
        this.clientOrderId = i11;
    }

    public void setErrCode(int i11) {
        this.errCode = i11;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public String toString() {
        return "LinearSwapOrderErrorInfo(orderId=" + getOrderId() + ", clientOrderId=" + getClientOrderId() + ", errCode=" + getErrCode() + ", errMsg=" + getErrMsg() + ")";
    }
}
