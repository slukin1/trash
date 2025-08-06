package com.hbg.lib.network.linear.swap.core.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.hbg.lib.network.retrofit.response.IResponse;

public class LinearSwapStatusResponse<T> implements IResponse {
    private static final long serialVersionUID = 5240281027013419414L;
    private int code;
    private T data;
    @SerializedName("err_code")
    private String errCode;
    @SerializedName("err_msg")
    private String errMsg;
    private String message;
    private String status;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getErrCode() {
        String str = this.errCode;
        return (str == null || str.isEmpty()) ? String.valueOf(this.code) : this.errCode;
    }

    public String getErrMsg() {
        String str = this.errMsg;
        return (str == null || str.isEmpty()) ? this.message : this.errMsg;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.code == 200 || BaseHbgResponse.STATUS_OK.equalsIgnoreCase(this.status);
    }

    public void setCode(int i11) {
        this.code = i11;
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

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
