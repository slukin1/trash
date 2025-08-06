package com.amazonaws;

public class AmazonClientException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public AmazonClientException(String str, Throwable th2) {
        super(str, th2);
    }

    public boolean isRetryable() {
        return true;
    }

    public AmazonClientException(String str) {
        super(str);
    }

    public AmazonClientException(Throwable th2) {
        super(th2);
    }
}
