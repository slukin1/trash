package com.facebook;

public class FacebookAuthorizationException extends FacebookException {
    public static final long serialVersionUID = 1;

    public FacebookAuthorizationException() {
    }

    public FacebookAuthorizationException(String str) {
        super(str);
    }

    public FacebookAuthorizationException(String str, Throwable th2) {
        super(str, th2);
    }

    public FacebookAuthorizationException(Throwable th2) {
        super(th2);
    }
}
