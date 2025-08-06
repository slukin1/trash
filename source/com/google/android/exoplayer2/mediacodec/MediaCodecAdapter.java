package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface MediaCodecAdapter {

    public static final class Configuration {
        public final MediaCodecInfo codecInfo;
        public final MediaCrypto crypto;
        public final int flags;
        public final Format format;
        public final MediaFormat mediaFormat;
        public final Surface surface;

        public Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat2, Format format2, Surface surface2, MediaCrypto mediaCrypto, int i11) {
            this.codecInfo = mediaCodecInfo;
            this.mediaFormat = mediaFormat2;
            this.format = format2;
            this.surface = surface2;
            this.crypto = mediaCrypto;
            this.flags = i11;
        }
    }

    public interface Factory {
        public static final Factory DEFAULT = new SynchronousMediaCodecAdapter.Factory();

        MediaCodecAdapter createAdapter(Configuration configuration) throws IOException;
    }

    public interface OnFrameRenderedListener {
        void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j11, long j12);
    }

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    ByteBuffer getInputBuffer(int i11);

    ByteBuffer getOutputBuffer(int i11);

    MediaFormat getOutputFormat();

    void queueInputBuffer(int i11, int i12, int i13, long j11, int i14);

    void queueSecureInputBuffer(int i11, int i12, CryptoInfo cryptoInfo, long j11, int i13);

    void release();

    void releaseOutputBuffer(int i11, long j11);

    void releaseOutputBuffer(int i11, boolean z11);

    void setOnFrameRenderedListener(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    void setOutputSurface(Surface surface);

    void setParameters(Bundle bundle);

    void setVideoScalingMode(int i11);
}
