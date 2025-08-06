package com.amazonaws.services.s3;

public class KeyWrapException extends SecurityException {
    private static final long serialVersionUID = 1;

    public KeyWrapException() {
    }

    public KeyWrapException(String str) {
        super(str);
    }

    public KeyWrapException(String str, Throwable th2) {
        super(str, th2);
    }

    public KeyWrapException(Throwable th2) {
        super(th2);
    }
}
