package com.huobi.woodpecker.kalle;

import java.io.IOException;
import java.io.OutputStream;

public interface h {
    String contentType();

    long length();

    void writeTo(OutputStream outputStream) throws IOException;
}
