package com.hbg.lib.network.newkyc.response;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.hbg.lib.network.retrofit.response.IResponse;

public class NewKycCodeResponse<T> implements IResponse {
    private static final long serialVersionUID = 698384526019797713L;
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private T data;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private String status;
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
        return (this.code == 200 && this.success) || TextUtils.equals(this.status, BaseHbgResponse.STATUS_OK);
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
