package com.twitter.sdk.android.core;

public class TwitterException extends RuntimeException {
    public TwitterException(String str) {
        super(str);
    }

    public TwitterException(String str, Throwable th2) {
        super(str, th2);
    }
}
