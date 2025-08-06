package org.bouncycastle.x509.util;

public class StreamParsingException extends Exception {
    public Throwable _e;

    public StreamParsingException(String str, Throwable th2) {
        super(str);
        this._e = th2;
    }

    public Throwable getCause() {
        return this._e;
    }
}
