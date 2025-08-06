package com.tencent.liteav;

public interface TXLiteAVExternalDecoderFactoryInterface {
    long createHevcDecoder();

    void destroyHevcDecoder(long j11);
}
