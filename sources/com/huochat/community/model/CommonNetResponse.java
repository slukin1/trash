package com.huochat.community.model;

import com.hbg.lib.network.retrofit.response.IResponse;

public class CommonNetResponse<T> implements IResponse {
    private int code;
    private T data;
    private String message;

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
        return this.code == 1;
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
}
