package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

public class MediaCodecWrapper {
    public static void configure(MediaCodec mediaCodec, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11) {
        mediaCodec.configure(mediaFormat, surface, mediaCrypto, i11);
    }

    public static int dequeueInputBuffer(MediaCodec mediaCodec, long j11) {
        return mediaCodec.dequeueInputBuffer(j11);
    }

    public static int dequeueOutputBuffer(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, long j11) {
        return mediaCodec.dequeueOutputBuffer(bufferInfo, j11);
    }

    public static void queueInputBuffer(MediaCodec mediaCodec, int i11, int i12, int i13, long j11, int i14) {
        mediaCodec.queueInputBuffer(i11, i12, i13, j11, i14);
    }
}
