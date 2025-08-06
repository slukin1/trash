package com.hbg.lib.network.pro.core.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.hbg.lib.network.retrofit.response.IResponse;

public class BigInterfaceResponse<T> implements IResponse {
    private T data;
    @SerializedName(alternate = {"err_code"}, value = "err-code")
    private String errCode;
    @SerializedName(alternate = {"err_msg"}, value = "err-msg")
    private String errMsg;
    @SerializedName("full")
    private int full;
    private String status;
    @SerializedName("ts")

    /* renamed from: ts  reason: collision with root package name */
    private String f70618ts;

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getFull() {
        return this.full;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTs() {
        return this.f70618ts;
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

    public void setFull(int i11) {
        this.full = i11;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTs(String str) {
        this.f70618ts = str;
    }
}
