package com.huobi.kalle.exception;

public class ParseError extends ReadException {
    public ParseError(String str) {
        super(str);
    }

    public ParseError(String str, Throwable th2) {
        super(str, th2);
    }
}
