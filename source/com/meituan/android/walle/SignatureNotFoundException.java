package com.meituan.android.walle;

public class SignatureNotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    public SignatureNotFoundException(String str) {
        super(str);
    }

    public SignatureNotFoundException(String str, Throwable th2) {
        super(str, th2);
    }
}
