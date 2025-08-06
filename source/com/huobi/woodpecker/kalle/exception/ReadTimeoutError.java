package com.huobi.woodpecker.kalle.exception;

public class ReadTimeoutError extends ReadException {
    public ReadTimeoutError(String str) {
        super(str);
    }

    public ReadTimeoutError(String str, Throwable th2) {
        super(str, th2);
    }
}
