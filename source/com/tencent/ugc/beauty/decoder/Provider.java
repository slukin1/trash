package com.tencent.ugc.beauty.decoder;

public interface Provider<T> {
    T dequeueOutputBuffer();

    void enqueueOutputBuffer(T t11);
}
