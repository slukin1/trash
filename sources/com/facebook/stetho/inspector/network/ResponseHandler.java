package com.facebook.stetho.inspector.network;

import java.io.IOException;

public interface ResponseHandler {
    void onEOF();

    void onError(IOException iOException);

    void onRead(int i11);

    void onReadDecoded(int i11);
}
