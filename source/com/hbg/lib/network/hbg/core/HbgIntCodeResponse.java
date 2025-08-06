package com.hbg.lib.network.hbg.core;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HbgIntCodeResponse<T> implements Serializable {
    @SerializedName("code")
    private int code;
    @SerializedName("data")
    private T data;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;

    /* renamed from: ts  reason: collision with root package name */
    private long f70214ts;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public long getTs() {
        return this.f70214ts;
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

    public void setTs(long j11) {
        this.f70214ts = j11;
    }
}
