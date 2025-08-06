package com.tencent.ugc.decoder;

import com.tencent.ugc.videobase.frame.PixelFrame;
import java.nio.ByteBuffer;

public abstract class VideoDecoderListener {
    public void onAbandonDecodingFramesCompleted() {
    }

    public void onDecodeCompleted() {
    }

    public void onDecodeFailed() {
    }

    public void onDecodeFrame(PixelFrame pixelFrame, long j11) {
    }

    public void onDecodeLatencyChanged(boolean z11) {
    }

    public void onDecodeSEI(ByteBuffer byteBuffer) {
    }

    public void onRequestKeyFrame() {
    }
}
