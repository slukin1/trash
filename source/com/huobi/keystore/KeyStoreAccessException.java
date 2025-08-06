package com.huobi.keystore;

public class KeyStoreAccessException extends RuntimeException {
    public KeyStoreAccessException(String str, Throwable th2) {
        super(str, th2);
    }
}
