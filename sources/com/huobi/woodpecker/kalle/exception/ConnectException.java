package com.huobi.woodpecker.kalle.exception;

import java.io.IOException;

public class ConnectException extends IOException {
    public ConnectException(String str) {
        super(str);
    }

    public ConnectException(String str, Throwable th2) {
        super(str, th2);
    }

    public ConnectException(Throwable th2) {
        super(th2);
    }
}
