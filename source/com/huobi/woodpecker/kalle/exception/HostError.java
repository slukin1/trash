package com.huobi.woodpecker.kalle.exception;

public class HostError extends ConnectException {
    public HostError(String str) {
        super(str);
    }

    public HostError(String str, Throwable th2) {
        super(str, th2);
    }
}
