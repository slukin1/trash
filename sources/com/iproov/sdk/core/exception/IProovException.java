package com.iproov.sdk.core.exception;

public class IProovException extends Exception {
    private final String reason;

    public IProovException(String str, String str2) {
        super(str2);
        this.reason = str;
    }

    public String getReason() {
        return this.reason;
    }

    public IProovException(String str, Exception exc) {
        super(str, exc);
        this.reason = str;
    }

    public IProovException(String str, Throwable th2) {
        super(str, th2);
        this.reason = str;
    }
}
