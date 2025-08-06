package com.hbg.lib.core.network.response;

import com.hbg.lib.network.retrofit.response.IResponse;

public class RiskIntCodeResponse<T> implements IResponse {
    private static final long serialVersionUID = -5465868120561652059L;
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
        return this.code == 200;
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
