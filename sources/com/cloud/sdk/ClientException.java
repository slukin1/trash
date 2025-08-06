package com.cloud.sdk;

public class ClientException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public ClientException(String str, Throwable th2) {
        super(str, th2);
    }

    public boolean isRetryable() {
        return true;
    }

    public ClientException(String str) {
        super(str);
    }

    public ClientException(Throwable th2) {
        super(th2);
    }
}
