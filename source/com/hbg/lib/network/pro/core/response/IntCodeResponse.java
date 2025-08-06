package com.hbg.lib.network.pro.core.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.retrofit.response.IResponse;

public class IntCodeResponse<T> implements IResponse {
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private T data;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        int i11 = this.code;
        return (i11 == 200 && this.success) || i11 == 200;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z11) {
        this.success = z11;
    }
}
