package com.hbg.lib.common.network.exception;

public class NetException extends RuntimeException {
    private String code;
    private String showMessage;

    public NetException(String str, String str2) {
        this.code = str;
        this.showMessage = str2;
    }

    public String getCode() {
        return this.code;
    }

    public String getShowMessage() {
        return this.showMessage;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setShowMessage(String str) {
        this.showMessage = str;
    }
}
