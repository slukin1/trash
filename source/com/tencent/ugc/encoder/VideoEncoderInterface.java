package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.videobase.frame.PixelFrame;

public interface VideoEncoderInterface {

    public static abstract class VideoEncoderListener extends VideoEncoderDef.VideoEncoderDataListener {
        public void onRequestRestart() {
        }
    }

    void encodeFrame(PixelFrame pixelFrame);

    void initialize();

    boolean isInputQueueFull();

    void signalEndOfStream();

    boolean start(VideoEncodeParams videoEncodeParams, VideoEncoderListener videoEncoderListener);

    void stopSync(long j11);

    void uninitialize();
}
