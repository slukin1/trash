package com.huobi.kalle.exception;

public class NoCacheError extends ReadException {
    public NoCacheError(String str) {
        super(str);
    }

    public NoCacheError(String str, Throwable th2) {
        super(str, th2);
    }
}
