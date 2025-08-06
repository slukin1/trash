package com.facebook;

public class FacebookOperationCanceledException extends FacebookException {
    public static final long serialVersionUID = 1;

    public FacebookOperationCanceledException() {
    }

    public FacebookOperationCanceledException(String str) {
        super(str);
    }

    public FacebookOperationCanceledException(String str, Throwable th2) {
        super(str, th2);
    }

    public FacebookOperationCanceledException(Throwable th2) {
        super(th2);
    }
}
