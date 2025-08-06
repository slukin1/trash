package com.tencent.ugc.decoder;

import com.tencent.ugc.videobase.frame.PixelFrame;

public interface UGCVideoDecodeControllerListener {
    void onAbandonDecodingFramesCompleted();

    void onDecodeCompleted();

    void onDecodeFailed();

    void onFrameDecoded(PixelFrame pixelFrame);

    void onFrameEnqueuedToDecoder();

    void onRequestSeekToLastKeyFrame(long j11);
}
