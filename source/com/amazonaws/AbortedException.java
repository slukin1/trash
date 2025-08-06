package com.amazonaws;

public class AbortedException extends AmazonClientException {
    private static final long serialVersionUID = 1;

    public AbortedException(String str, Throwable th2) {
        super(str, th2);
    }

    public boolean isRetryable() {
        return false;
    }

    public AbortedException(Throwable th2) {
        super("", th2);
    }

    public AbortedException(String str) {
        super(str);
    }

    public AbortedException() {
        super("");
    }
}
