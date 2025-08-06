package com.tencent.ugc.decoder;

import com.tencent.ugc.decoder.VideoDecoderDef;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;

public interface VideoDecoderInterface {

    public enum DecoderType {
        SOFTWARE(0),
        HARDWARE(1),
        CUSTOM(2),
        SOFTWARE_DEVICE(3);
        
        public int mValue;

        private DecoderType(int i11) {
            this.mValue = i11;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    void abandonDecodingFrames();

    boolean decode(EncodedVideoFrame encodedVideoFrame);

    DecoderType getDecoderType();

    void initialize();

    void setScene(VideoDecoderDef.ConsumerScene consumerScene);

    void start(Object obj, VideoDecoderListener videoDecoderListener);

    void stop();

    void uninitialize();
}
