package com.tencent.ugc.beauty.decoder;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import java.nio.ByteBuffer;

public abstract class ExtractorAdvancer {
    public MediaExtractor mMediaExtractor;

    public abstract boolean advance();

    public abstract long getSampleTime();

    public abstract void readSampleData(MediaCodec.BufferInfo bufferInfo, ByteBuffer byteBuffer, int i11);

    public void updateExtractor(MediaExtractor mediaExtractor) {
        this.mMediaExtractor = mediaExtractor;
    }
}
