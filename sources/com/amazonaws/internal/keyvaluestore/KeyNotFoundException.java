package com.amazonaws.internal.keyvaluestore;

public class KeyNotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    public KeyNotFoundException(String str, Throwable th2) {
        super(str, th2);
    }

    public KeyNotFoundException(String str) {
        super(str);
    }

    public KeyNotFoundException(Throwable th2) {
        super(th2);
    }
}
