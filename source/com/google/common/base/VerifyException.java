package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public class VerifyException extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(String str) {
        super(str);
    }

    public VerifyException(Throwable th2) {
        super(th2);
    }

    public VerifyException(String str, Throwable th2) {
        super(str, th2);
    }
}
