package com.jumio.sdk.exceptions;

public class SDKNotConfiguredException extends Exception {
    public SDKNotConfiguredException() {
    }

    public SDKNotConfiguredException(String str) {
        super(str);
    }

    public SDKNotConfiguredException(Throwable th2) {
        super(th2);
    }

    public SDKNotConfiguredException(String str, Throwable th2) {
        super(str, th2);
    }
}
