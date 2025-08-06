package com.jumio.sdk.exceptions;

public class PlatformNotSupportedException extends Exception {
    public PlatformNotSupportedException() {
    }

    public PlatformNotSupportedException(String str) {
        super(str);
    }

    public PlatformNotSupportedException(Throwable th2) {
        super(th2);
    }

    public PlatformNotSupportedException(String str, Throwable th2) {
        super(str, th2);
    }
}
