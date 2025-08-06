package com.hbg.lib.network.inst.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.retrofit.response.IResponse;

public class InstCodeResponse<T> implements IResponse {
    private static final long serialVersionUID = 2517383545254728849L;
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
        return this.code == 200 && this.success;
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
