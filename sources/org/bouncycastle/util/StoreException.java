package org.bouncycastle.util;

public class StoreException extends RuntimeException {
    private Throwable _e;

    public StoreException(String str, Throwable th2) {
        super(str);
        this._e = th2;
    }

    public Throwable getCause() {
        return this._e;
    }
}
