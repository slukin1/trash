package com.tencent.ugc.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.ugc.decoder.VideoDecoderInterface;
import com.tencent.ugc.videobase.common.CodecType;

@JNINamespace("liteav::ugc")
public interface VideoDecoderDef {

    public enum ConsumerScene {
        UNKNOWN(-1),
        LIVE(0),
        RTC(1);
        
        private static final ConsumerScene[] VALUES = null;
        private int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private ConsumerScene(int i11) {
            this.mValue = i11;
        }

        public static ConsumerScene fromInteger(int i11) {
            for (ConsumerScene consumerScene : VALUES) {
                if (consumerScene.mValue == i11) {
                    return consumerScene;
                }
            }
            return UNKNOWN;
        }
    }

    public static class DecodeAbility {
        public boolean isSupportHEVC;
        public boolean isSupportRPS;
        public boolean isSupportSVC;

        public DecodeAbility(boolean z11, boolean z12, boolean z13) {
            this.isSupportRPS = z11;
            this.isSupportSVC = z12;
            this.isSupportHEVC = z13;
        }

        public boolean isSupportHEVC() {
            return this.isSupportHEVC;
        }

        public boolean isSupportRPS() {
            return this.isSupportRPS;
        }

        public boolean isSupportSVC() {
            return this.isSupportSVC;
        }
    }

    public static class DecoderProperty {
        public VideoDecoderInterface.DecoderType decoderType;
        public CodecType videoCodec;

        public DecoderProperty(VideoDecoderInterface.DecoderType decoderType2, CodecType codecType) {
            this.decoderType = decoderType2;
            this.videoCodec = codecType;
        }

        public int getCodecType() {
            return this.videoCodec.getValue();
        }

        public int getDecoderType() {
            return this.decoderType.getValue();
        }
    }

    public enum WritableState {
        UNKNOWN(-1),
        NORMAL_WRITABLE(0),
        NORMAL_UNWRITABLE(1),
        FAST_WRITABLE(2),
        FAST_UNWRITABLE(3);
        
        private final int mValue;

        private WritableState(int i11) {
            this.mValue = i11;
        }

        public final int getValue() {
            return this.mValue;
        }
    }
}
