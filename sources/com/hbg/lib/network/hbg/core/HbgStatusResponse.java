package com.hbg.lib.network.hbg.core;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import java.io.Serializable;

public class HbgStatusResponse<T> implements Serializable {
    private static final long serialVersionUID = 5240281027013419413L;
    private T data;
    @SerializedName(alternate = {"err_code"}, value = "err-code")
    private String errCode;
    @SerializedName(alternate = {"err_msg"}, value = "err-msg")
    private String errMsg;
    private String status;

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.status.equalsIgnoreCase(BaseHbgResponse.STATUS_OK);
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
