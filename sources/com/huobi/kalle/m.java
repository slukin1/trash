package com.huobi.kalle;

import java.io.Closeable;
import java.io.IOException;

public interface m extends Closeable {
    byte[] byteArray() throws IOException;

    String string() throws IOException;
}
