package com.huobi.network.interceptor;

import com.huobi.network.interceptor.BaseTokenErrorCheckInterceptor;

public class OtcErrorCheckInterceptor$OtcErrorHandleResponse extends BaseTokenErrorCheckInterceptor.BaseTokenErrorHandleResponse {
    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getErrCode() {
        return this.code + "";
    }

    public String getErrMsg() {
        return this.message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return "";
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public boolean isTokenError() {
        return getCode() == 401;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
