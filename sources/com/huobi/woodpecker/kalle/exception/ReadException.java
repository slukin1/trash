package com.huobi.woodpecker.kalle.exception;

import java.io.IOException;

public class ReadException extends IOException {
    public ReadException(String str) {
        super(str);
    }

    public ReadException(String str, Throwable th2) {
        super(str, th2);
    }

    public ReadException(Throwable th2) {
        super(th2);
    }
}
