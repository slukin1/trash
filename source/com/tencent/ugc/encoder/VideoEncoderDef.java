package com.tencent.ugc.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.ugc.videobase.common.CodecType;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;

@JNINamespace("liteav::ugc")
public interface VideoEncoderDef {

    public enum BitrateMode {
        CBR(0),
        VBR(1),
        CQ(2);
        
        private static final BitrateMode[] VALUES = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private BitrateMode(int i11) {
            this.mValue = i11;
        }

        public static BitrateMode fromInteger(int i11) {
            for (BitrateMode bitrateMode : VALUES) {
                if (i11 == bitrateMode.getValue()) {
                    return bitrateMode;
                }
            }
            return VBR;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public static class EncodeAbility {
        public boolean isSupportHwHEVC;
        public boolean isSupportRPS;
        public boolean isSupportSVC;
        public boolean isSupportSwHEVC;

        public EncodeAbility(boolean z11, boolean z12, boolean z13, boolean z14) {
            this.isSupportRPS = z11;
            this.isSupportSVC = z12;
            this.isSupportSwHEVC = z13;
            this.isSupportHwHEVC = z14;
        }

        public boolean isSupportHwHEVC() {
            return this.isSupportHwHEVC;
        }

        public boolean isSupportRPS() {
            return this.isSupportRPS;
        }

        public boolean isSupportSVC() {
            return this.isSupportSVC;
        }

        public boolean isSupportSwHEVC() {
            return this.isSupportSwHEVC;
        }
    }

    public enum EncodeScene {
        kCameraRealTime(0),
        kScreenRealTime(1);
        
        public int mValue;

        private EncodeScene(int i11) {
            this.mValue = i11;
        }

        public static EncodeScene fromInteger(int i11) {
            for (EncodeScene encodeScene : values()) {
                if (encodeScene.mValue == i11) {
                    return encodeScene;
                }
            }
            return kCameraRealTime;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public enum EncodeStrategy {
        PREFER_HARDWARE(0),
        PREFER_SOFTWARE(1),
        USE_HARDWARE_ONLY(2),
        USE_SOFTWARE_ONLY(3);
        
        private static final EncodeStrategy[] VALUES = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private EncodeStrategy(int i11) {
            this.mValue = i11;
        }

        public static EncodeStrategy fromInteger(int i11) {
            for (EncodeStrategy encodeStrategy : VALUES) {
                if (encodeStrategy.mValue == i11) {
                    return encodeStrategy;
                }
            }
            return PREFER_HARDWARE;
        }
    }

    public enum EncoderComplexity {
        UNKNOWN(65535),
        HYPER_FAST(0),
        ULTRA_FAST(1),
        SUPER_FAST(2),
        VERY_FAST(3),
        FAST(4);
        
        private final int mValue;

        private EncoderComplexity(int i11) {
            this.mValue = i11;
        }

        public static EncoderComplexity fromInteger(int i11) {
            for (EncoderComplexity encoderComplexity : values()) {
                if (encoderComplexity.mValue == i11) {
                    return encoderComplexity;
                }
            }
            return UNKNOWN;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public enum EncoderProfile {
        PROFILE_BASELINE(1),
        PROFILE_MAIN(2),
        PROFILE_HIGH(3),
        PROFILE_BASELINERPS(11),
        PROFILE_MAINRPS(12),
        PROFILE_HIGHRPS(13);
        
        private static final EncoderProfile[] VALUES = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private EncoderProfile(int i11) {
            this.mValue = i11;
        }

        public static EncoderProfile fromInteger(int i11) {
            for (EncoderProfile encoderProfile : VALUES) {
                if (i11 == encoderProfile.getValue()) {
                    return encoderProfile;
                }
            }
            return PROFILE_BASELINE;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public static class EncoderProperty {
        public EncoderType encoderType;
        public ReferenceStrategy referenceStrategy;
        public CodecType videoCodec;

        public EncoderProperty(EncoderType encoderType2, ReferenceStrategy referenceStrategy2, CodecType codecType) {
            this.encoderType = encoderType2;
            this.referenceStrategy = referenceStrategy2;
            this.videoCodec = codecType;
        }

        public int getCodecType() {
            return this.videoCodec.getValue();
        }

        public int getEncoderType() {
            return this.encoderType.getValue();
        }

        public int getReferenceStrategy() {
            return this.referenceStrategy.getValue();
        }
    }

    public enum EncoderType {
        HARDWARE(1),
        SOFTWARE(2);
        
        public int value;

        private EncoderType(int i11) {
            this.value = i11;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum ReferenceStrategy {
        FIX_GOP(0),
        RPS(1),
        SVC(2),
        UNLIMITED_GOP(3);
        
        private static final ReferenceStrategy[] VALUES = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            VALUES = values();
        }

        private ReferenceStrategy(int i11) {
            this.mValue = i11;
        }

        public static ReferenceStrategy fromInteger(int i11) {
            for (ReferenceStrategy referenceStrategy : VALUES) {
                if (i11 == referenceStrategy.getValue()) {
                    return referenceStrategy;
                }
            }
            return FIX_GOP;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public static abstract class VideoEncoderDataListener {
        public void onEncodedFail() {
        }

        public void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
        }

        public void onOutputFormatChanged(MediaFormat mediaFormat) {
        }
    }
}
