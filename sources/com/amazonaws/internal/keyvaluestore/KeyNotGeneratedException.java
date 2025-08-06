package com.amazonaws.internal.keyvaluestore;

public class KeyNotGeneratedException extends Exception {
    public KeyNotGeneratedException() {
    }

    public KeyNotGeneratedException(String str) {
        super(str);
    }

    public KeyNotGeneratedException(String str, Throwable th2) {
        super(str, th2);
    }

    public KeyNotGeneratedException(Throwable th2) {
        super(th2);
    }
}
