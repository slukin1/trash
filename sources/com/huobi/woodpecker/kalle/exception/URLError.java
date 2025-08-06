package com.huobi.woodpecker.kalle.exception;

public class URLError extends ConnectException {
    public URLError(String str) {
        super(str);
    }

    public URLError(String str, Throwable th2) {
        super(str, th2);
    }
}
