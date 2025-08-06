package org.tensorflow.lite;

import java.io.Closeable;

public interface Delegate extends Closeable {
    void close();

    long getNativeHandle();
}
