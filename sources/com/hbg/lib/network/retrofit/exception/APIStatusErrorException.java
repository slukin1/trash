package com.hbg.lib.network.retrofit.exception;

public class APIStatusErrorException extends RuntimeException {
    private Object data;
    private String errCode;
    private String errMsg;

    public APIStatusErrorException(String str, String str2) {
        this.errCode = str;
        this.errMsg = str2;
    }

    public <T> T getData() {
        return this.data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(String str) {
        this.errCode = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public String toString() {
        return "APIStatusErrorException{errCode='" + this.errCode + '\'' + ", errMsg='" + this.errMsg + '\'' + '}';
    }

    public APIStatusErrorException(String str, String str2, Object obj) {
        this.errCode = str;
        this.errMsg = str2;
        this.data = obj;
    }
}
