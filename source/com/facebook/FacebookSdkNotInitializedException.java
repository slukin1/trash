package com.facebook;

public class FacebookSdkNotInitializedException extends FacebookException {
    public static final long serialVersionUID = 1;

    public FacebookSdkNotInitializedException() {
    }

    public FacebookSdkNotInitializedException(String str) {
        super(str);
    }

    public FacebookSdkNotInitializedException(String str, Throwable th2) {
        super(str, th2);
    }

    public FacebookSdkNotInitializedException(Throwable th2) {
        super(th2);
    }
}
