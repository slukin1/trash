package com.facebook;

public class FacebookDialogException extends FacebookException {
    public static final long serialVersionUID = 1;
    private int errorCode;
    private String failingUrl;

    public FacebookDialogException(String str, int i11, String str2) {
        super(str);
        this.errorCode = i11;
        this.failingUrl = str2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFailingUrl() {
        return this.failingUrl;
    }

    public final String toString() {
        return "{FacebookDialogException: " + "errorCode: " + getErrorCode() + ", message: " + getMessage() + ", url: " + getFailingUrl() + "}";
    }
}
