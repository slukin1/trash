package com.facebook.stetho.websocket;

public interface SimpleEndpoint {
    void onClose(SimpleSession simpleSession, int i11, String str);

    void onError(SimpleSession simpleSession, Throwable th2);

    void onMessage(SimpleSession simpleSession, String str);

    void onMessage(SimpleSession simpleSession, byte[] bArr, int i11);

    void onOpen(SimpleSession simpleSession);
}
