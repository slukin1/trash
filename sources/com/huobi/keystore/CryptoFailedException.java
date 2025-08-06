package com.huobi.keystore;

public class CryptoFailedException extends RuntimeException {
    public CryptoFailedException(String str) {
        super(str);
    }

    public CryptoFailedException(String str, Throwable th2) {
        super(str, th2);
    }
}
