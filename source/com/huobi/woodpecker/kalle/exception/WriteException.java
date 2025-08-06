package com.huobi.woodpecker.kalle.exception;

import java.io.IOException;

public class WriteException extends IOException {
    public WriteException(String str) {
        super(str);
    }

    public WriteException(String str, Throwable th2) {
        super(str, th2);
    }

    public WriteException(Throwable th2) {
        super(th2);
    }
}
