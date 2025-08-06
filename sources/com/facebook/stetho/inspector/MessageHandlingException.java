package com.facebook.stetho.inspector;

public class MessageHandlingException extends Exception {
    public MessageHandlingException(Throwable th2) {
        super(th2);
    }

    public MessageHandlingException(String str) {
        super(str);
    }
}
