package com.eclipsesource.v8;

import java.io.Closeable;

public interface Releasable extends Closeable {
    void close();

    void release();
}
