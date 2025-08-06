package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.e;

@JNINamespace("liteav::video")
public interface VideoEncoderDef {

    public enum BitrateMode {
        UNKNOWN(-1),
        CBR(0),
        VBR(1),
        CQ(2);
        

        /* renamed from: e  reason: collision with root package name */
        private static final BitrateMode[] f22620e = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            f22620e = values();
        }

        private BitrateMode(int i11) {
            this.mValue = i11;
        }

        public static BitrateMode a(int i11) {
            for (BitrateMode bitrateMode : f22620e) {
                if (i11 == bitrateMode.mValue) {
                    return bitrateMode;
                }
            }
            return VBR;
        }
    }

    public static class EncodeAbility {

        /* renamed from: a  reason: collision with root package name */
        public boolean f22622a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f22623b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22624c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22625d;

        public boolean isSupportHwHEVC() {
            return this.f22625d;
        }

        public boolean isSupportRPS() {
            return this.f22622a;
        }

        public boolean isSupportSVC() {
            return this.f22623b;
        }

        public boolean isSupportSwHEVC() {
            return this.f22624c;
        }
    }

    public enum EncodeScene {
        kCameraRealTime(0),
        kScreenRealTime(1);
        
        public int mValue;

        private EncodeScene(int i11) {
            this.mValue = i11;
        }

        public static EncodeScene a(int i11) {
            for (EncodeScene encodeScene : values()) {
                if (encodeScene.mValue == i11) {
                    return encodeScene;
                }
            }
            return kCameraRealTime;
        }
    }

    public enum EncoderComplexity {
        UNKNOWN(65535),
        HYPER_FAST(0),
        ULTRA_FAST(1),
        SUPER_FAST(2),
        VERY_FAST(3),
        FAST(4);
        
        public final int mValue;

        private EncoderComplexity(int i11) {
            this.mValue = i11;
        }

        public static EncoderComplexity a(int i11) {
            for (EncoderComplexity encoderComplexity : values()) {
                if (encoderComplexity.mValue == i11) {
                    return encoderComplexity;
                }
            }
            return UNKNOWN;
        }
    }

    public enum EncoderProfile {
        PROFILE_BASELINE(1),
        PROFILE_MAIN(2),
        PROFILE_HIGH(3),
        PROFILE_BASELINERPS(11),
        PROFILE_MAINRPS(12),
        PROFILE_HIGHRPS(13);
        

        /* renamed from: g  reason: collision with root package name */
        private static final EncoderProfile[] f22642g = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            f22642g = values();
        }

        private EncoderProfile(int i11) {
            this.mValue = i11;
        }

        public static EncoderProfile a(int i11) {
            for (EncoderProfile encoderProfile : f22642g) {
                if (i11 == encoderProfile.mValue) {
                    return encoderProfile;
                }
            }
            return PROFILE_BASELINE;
        }
    }

    public static class EncoderProperty {

        /* renamed from: a  reason: collision with root package name */
        public a f22644a;

        /* renamed from: b  reason: collision with root package name */
        public ReferenceStrategy f22645b;

        /* renamed from: c  reason: collision with root package name */
        public CodecType f22646c;

        public int getCodecType() {
            return this.f22646c.mValue;
        }

        public int getEncoderType() {
            return this.f22644a.value;
        }

        public int getReferenceStrategy() {
            return this.f22645b.mValue;
        }
    }

    public enum ReferenceStrategy {
        FIX_GOP(0),
        RPS(1),
        SVC(2),
        UNLIMITED_GOP(3);
        

        /* renamed from: e  reason: collision with root package name */
        private static final ReferenceStrategy[] f22651e = null;
        public int mValue;

        /* access modifiers changed from: public */
        static {
            f22651e = values();
        }

        private ReferenceStrategy(int i11) {
            this.mValue = i11;
        }

        public static ReferenceStrategy a(int i11) {
            for (ReferenceStrategy referenceStrategy : f22651e) {
                if (i11 == referenceStrategy.mValue) {
                    return referenceStrategy;
                }
            }
            return FIX_GOP;
        }
    }

    public enum a {
        HARDWARE(1),
        SOFTWARE(2);
        
        public int value;

        private a(int i11) {
            this.value = i11;
        }
    }

    public static abstract class b {
        public void onBitrateModeUpdated(BitrateMode bitrateMode) {
        }

        public void onEncodedFail(e.a aVar) {
        }

        public void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
        }

        public void onOutputFormatChanged(MediaFormat mediaFormat) {
        }
    }
}
