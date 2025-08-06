package com.huobi.woodpecker.kalle.exception;

public class NetworkError extends ConnectException {
    public NetworkError(String str) {
        super(str);
    }

    public NetworkError(String str, Throwable th2) {
        super(str, th2);
    }
}
