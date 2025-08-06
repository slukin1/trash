package com.huobi.woodpecker.kalle.exception;

public class ConnectTimeoutError extends ConnectException {
    public ConnectTimeoutError(String str) {
        super(str);
    }

    public ConnectTimeoutError(String str, Throwable th2) {
        super(str, th2);
    }
}
