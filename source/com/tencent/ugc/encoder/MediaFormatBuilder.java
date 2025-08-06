package com.tencent.ugc.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Pair;
import android.util.Range;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.videobase.common.CodecType;
import org.json.JSONObject;

public class MediaFormatBuilder {
    private static final String MIME_TYPE_H264 = "video/avc";
    private static final String MIME_TYPE_H265 = "video/hevc";
    private static final String TAG = "MediaFormatBuilder";
    private boolean mEnableSetBitrateModeIfSupport = true;
    private final MediaCodec mMediaCodec;
    private final String mMimeType;
    private boolean mUseProfileAndLevel = true;
    private final VideoEncodeParams mVideoEncodeParams;

    /* renamed from: com.tencent.ugc.encoder.MediaFormatBuilder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50419a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f50420b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.tencent.ugc.encoder.VideoEncoderDef$EncoderProfile[] r0 = com.tencent.ugc.encoder.VideoEncoderDef.EncoderProfile.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50420b = r0
                r1 = 1
                com.tencent.ugc.encoder.VideoEncoderDef$EncoderProfile r2 = com.tencent.ugc.encoder.VideoEncoderDef.EncoderProfile.PROFILE_MAIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f50420b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.ugc.encoder.VideoEncoderDef$EncoderProfile r3 = com.tencent.ugc.encoder.VideoEncoderDef.EncoderProfile.PROFILE_HIGH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f50420b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.ugc.encoder.VideoEncoderDef$EncoderProfile r4 = com.tencent.ugc.encoder.VideoEncoderDef.EncoderProfile.PROFILE_BASELINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.tencent.ugc.encoder.VideoEncoderDef$BitrateMode[] r3 = com.tencent.ugc.encoder.VideoEncoderDef.BitrateMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f50419a = r3
                com.tencent.ugc.encoder.VideoEncoderDef$BitrateMode r4 = com.tencent.ugc.encoder.VideoEncoderDef.BitrateMode.CBR     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f50419a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.tencent.ugc.encoder.VideoEncoderDef$BitrateMode r3 = com.tencent.ugc.encoder.VideoEncoderDef.BitrateMode.VBR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f50419a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.tencent.ugc.encoder.VideoEncoderDef$BitrateMode r1 = com.tencent.ugc.encoder.VideoEncoderDef.BitrateMode.CQ     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.encoder.MediaFormatBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public MediaFormatBuilder(MediaCodec mediaCodec, String str, VideoEncodeParams videoEncodeParams) {
        this.mMediaCodec = mediaCodec;
        this.mMimeType = str;
        this.mVideoEncodeParams = videoEncodeParams;
    }

    private MediaFormat createBaseFormat() {
        int i11;
        MediaFormat createVideoFormat;
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        int i12 = videoEncodeParams.width;
        if (i12 == 0 || (i11 = videoEncodeParams.height) == 0 || videoEncodeParams.bitrate == 0 || videoEncodeParams.fps == 0 || (createVideoFormat = MediaFormat.createVideoFormat(this.mMimeType, i12, i11)) == null) {
            return null;
        }
        createVideoFormat.setInteger("bitrate", this.mVideoEncodeParams.bitrate * 1024);
        createVideoFormat.setInteger("frame-rate", this.mVideoEncodeParams.fps);
        createVideoFormat.setInteger("color-format", 2130708361);
        VideoEncodeParams videoEncodeParams2 = this.mVideoEncodeParams;
        createVideoFormat.setInteger("i-frame-interval", videoEncodeParams2.fullIFrame ? 0 : videoEncodeParams2.gop);
        return createVideoFormat;
    }

    private MediaCodecInfo.CodecCapabilities createCodecCapabilities(MediaFormat mediaFormat) {
        if (mediaFormat == null || LiteavSystemInfo.getSystemOSVersionInt() < 23) {
            return null;
        }
        Pair<Integer, Integer> profileAndLevel = getProfileAndLevel(mediaFormat);
        return MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.mMimeType, ((Integer) profileAndLevel.first).intValue(), ((Integer) profileAndLevel.second).intValue());
    }

    private MediaCodecInfo.CodecCapabilities getCodecCapabilities() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i11 = 0; i11 < codecCount; i11++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i11);
            if (codecInfoAt.isEncoder()) {
                for (String equalsIgnoreCase : codecInfoAt.getSupportedTypes()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(this.mMimeType)) {
                        return codecInfoAt.getCapabilitiesForType(this.mMimeType);
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static int getMediaCodecBitrateMode(VideoEncoderDef.BitrateMode bitrateMode) {
        int i11;
        if (bitrateMode == null || (i11 = AnonymousClass1.f50419a[bitrateMode.ordinal()]) == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? 2 : 0;
        }
        return 1;
    }

    private static int getMediaCodecProfile(VideoEncoderDef.EncoderProfile encoderProfile, boolean z11) {
        if ((z11 && LiteavSystemInfo.getSystemOSVersionInt() >= 21) || encoderProfile == null) {
            return 1;
        }
        int i11 = AnonymousClass1.f50420b[encoderProfile.ordinal()];
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return 1;
        }
        return 8;
    }

    private Pair<Integer, Integer> getProfileAndLevel(MediaFormat mediaFormat) {
        int i11;
        int i12 = 0;
        try {
            i11 = mediaFormat.getInteger(Scopes.PROFILE);
        } catch (Throwable th2) {
            LiteavLog.i(TAG, "get profile fail.", th2);
            i11 = 0;
        }
        try {
            i12 = mediaFormat.getInteger(FirebaseAnalytics.Param.LEVEL);
        } catch (Throwable th3) {
            LiteavLog.i(TAG, "get level fail.", th3);
        }
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    private MediaCodecInfo.VideoCapabilities getVideoCapabilitiesByMimeType() {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (this.mMediaCodec == null || LiteavSystemInfo.getSystemOSVersionInt() < 21 || (capabilitiesForType = this.mMediaCodec.getCodecInfo().getCapabilitiesForType(this.mMimeType)) == null) {
            return null;
        }
        return capabilitiesForType.getVideoCapabilities();
    }

    private MediaCodecInfo.VideoCapabilities getVideoCapabilitiesByProfileLevel(int i11, int i12) {
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.mMimeType, i11, i12)) != null) {
            return createFromProfileLevel.getVideoCapabilities();
        }
        return null;
    }

    private boolean isBitrateModeSupported(int i11, MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        return encoderCapabilities.isBitrateModeSupported(i11);
    }

    private void setBitrateModeIfDeviceSupport(MediaFormat mediaFormat, MediaCodecInfo.CodecCapabilities codecCapabilities, int i11) {
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities != null) {
            if (isBitrateModeSupported(i11, encoderCapabilities)) {
                mediaFormat.setInteger("bitrate-mode", i11);
            } else if (this.mVideoEncodeParams.fullIFrame) {
                if (isBitrateModeSupported(1, encoderCapabilities)) {
                    mediaFormat.setInteger("bitrate-mode", 1);
                } else if (isBitrateModeSupported(2, encoderCapabilities)) {
                    mediaFormat.setInteger("bitrate-mode", 2);
                }
            } else if (isBitrateModeSupported(2, encoderCapabilities)) {
                mediaFormat.setInteger("bitrate-mode", 2);
            }
        }
    }

    private void setComplexity(MediaFormat mediaFormat, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        Range<Integer> complexityRange;
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = codecCapabilities.getEncoderCapabilities();
        if (encoderCapabilities != null && (complexityRange = encoderCapabilities.getComplexityRange()) != null) {
            mediaFormat.setInteger("complexity", complexityRange.getUpper().intValue());
        }
    }

    private void setDeviceRelatedParams(MediaFormat mediaFormat) {
        if (this.mVideoEncodeParams.mediaCodecDeviceRelatedParams != null) {
            for (int i11 = 0; i11 < this.mVideoEncodeParams.mediaCodecDeviceRelatedParams.length(); i11++) {
                try {
                    JSONObject jSONObject = this.mVideoEncodeParams.mediaCodecDeviceRelatedParams.getJSONObject(i11);
                    LiteavLog.i(TAG, "setDeviceRelatedParams,index=%d,key=%s,value=%d", Integer.valueOf(i11), jSONObject.optString("key"), Integer.valueOf(jSONObject.optInt("value")));
                    mediaFormat.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                } catch (Throwable th2) {
                    LiteavLog.e(TAG, "set mediaCodec device related params failed,index=".concat(String.valueOf(i11)), th2);
                }
            }
        }
    }

    private void setProfileAndLevel(MediaFormat mediaFormat, MediaCodecInfo.CodecCapabilities codecCapabilities, int i11) {
        int i12;
        int i13;
        int i14;
        if (this.mMimeType.equals("video/avc")) {
            i13 = 256;
            i12 = 32768;
        } else {
            i13 = Integer.MIN_VALUE;
            i12 = Integer.MAX_VALUE;
        }
        int i15 = 0;
        int i16 = 0;
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecCapabilities.profileLevels) {
            int i17 = codecProfileLevel.level;
            if (i17 >= i13 && (i14 = codecProfileLevel.profile) <= i11 && (i14 > i15 || (i14 == i15 && i17 > i16))) {
                i16 = Math.min(i17, i12);
                i15 = i14;
            }
        }
        mediaFormat.setInteger(Scopes.PROFILE, i15);
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            mediaFormat.setInteger(FirebaseAnalytics.Param.LEVEL, i16);
        }
    }

    private void updateBitRateFromSupportRange(MediaFormat mediaFormat, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (codecCapabilities != null && mediaFormat != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
            int integer = mediaFormat.getInteger("bitrate");
            int intValue = bitrateRange.clamp(Integer.valueOf(integer)).intValue();
            LiteavLog.i(TAG, "bitrateRange=(%d, %d),bitrate=%d,clampBitrate=%d", bitrateRange.getLower(), bitrateRange.getUpper(), Integer.valueOf(integer), Integer.valueOf(intValue));
            if (integer != intValue) {
                mediaFormat.setInteger("bitrate", intValue);
            }
        }
    }

    private void updateMediaFormatToLowerSize(MediaFormat mediaFormat, int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilitiesByProfileLevel;
        if (mediaFormat != null && (videoCapabilitiesByProfileLevel = getVideoCapabilitiesByProfileLevel(i11, i12)) != null) {
            Range<Integer> supportedWidths = videoCapabilitiesByProfileLevel.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilitiesByProfileLevel.getSupportedHeights();
            if (supportedWidths != null && supportedHeights != null) {
                Integer lower = supportedWidths.getLower();
                Integer lower2 = supportedHeights.getLower();
                MediaCodecInfo.VideoCapabilities videoCapabilitiesByMimeType = getVideoCapabilitiesByMimeType();
                if (videoCapabilitiesByMimeType != null) {
                    Range<Integer> supportedWidths2 = videoCapabilitiesByMimeType.getSupportedWidths();
                    Range<Integer> supportedHeights2 = videoCapabilitiesByMimeType.getSupportedHeights();
                    if (!(supportedWidths2 == null || supportedHeights2 == null)) {
                        lower = Integer.valueOf(Math.max(lower.intValue(), supportedWidths2.getLower().intValue()));
                        lower2 = Integer.valueOf(Math.max(lower2.intValue(), supportedHeights2.getLower().intValue()));
                    }
                }
                if (lower.intValue() >= 0 && lower2.intValue() >= 0) {
                    int integer = mediaFormat.getInteger("width");
                    int integer2 = mediaFormat.getInteger("height");
                    if (lower.intValue() > integer || lower2.intValue() > integer2) {
                        float f11 = (float) integer;
                        float f12 = (float) integer2;
                        float max = Math.max(((float) lower.intValue()) / (f11 * 1.0f), ((float) lower2.intValue()) / (1.0f * f12));
                        mediaFormat.setInteger("width", (int) (f11 * max));
                        mediaFormat.setInteger("height", (int) (max * f12));
                        LiteavLog.i(TAG, "updateMediaFormatToLowerSize:lowerW=%d,lowerH=%d", lower, lower2);
                    }
                }
            }
        }
    }

    private void updateMediaFormatToUpperSize(MediaFormat mediaFormat, int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilitiesByProfileLevel;
        if (mediaFormat != null && (videoCapabilitiesByProfileLevel = getVideoCapabilitiesByProfileLevel(i11, i12)) != null) {
            Range<Integer> supportedWidths = videoCapabilitiesByProfileLevel.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilitiesByProfileLevel.getSupportedHeights();
            if (supportedWidths != null && supportedHeights != null) {
                Integer upper = supportedWidths.getUpper();
                Integer upper2 = supportedHeights.getUpper();
                int integer = mediaFormat.getInteger("width");
                int integer2 = mediaFormat.getInteger("height");
                if ((integer > integer2 && upper.intValue() < upper2.intValue()) || (integer < integer2 && upper.intValue() > upper2.intValue())) {
                    Integer valueOf = Integer.valueOf(upper.intValue());
                    upper = upper2;
                    upper2 = valueOf;
                }
                if (upper.intValue() < integer || upper2.intValue() < integer2) {
                    float f11 = (float) integer;
                    float f12 = (float) integer2;
                    float min = Math.min(((float) upper.intValue()) / (f11 * 1.0f), ((float) upper2.intValue()) / (1.0f * f12));
                    mediaFormat.setInteger("width", (int) (f11 * min));
                    mediaFormat.setInteger("height", (int) (min * f12));
                    LiteavLog.i(TAG, "updateMediaFormatToUpperSize:srcWidth=%d,srcHeight=%d,upperW=%d,upperH=%d", Integer.valueOf(integer), Integer.valueOf(integer2), upper, upper2);
                }
            }
        }
    }

    private void updateMediaFormatWithAlignment(MediaFormat mediaFormat, int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilitiesByProfileLevel;
        if (mediaFormat != null && (videoCapabilitiesByProfileLevel = getVideoCapabilitiesByProfileLevel(i11, i12)) != null) {
            int widthAlignment = videoCapabilitiesByProfileLevel.getWidthAlignment();
            int heightAlignment = videoCapabilitiesByProfileLevel.getHeightAlignment();
            LiteavLog.i(TAG, "widthAlignment=%d,heightAlignment=%d", Integer.valueOf(widthAlignment), Integer.valueOf(heightAlignment));
            if (widthAlignment >= 2 && heightAlignment >= 2 && widthAlignment % 2 == 0 && heightAlignment % 2 == 0) {
                int integer = mediaFormat.getInteger("width");
                int integer2 = mediaFormat.getInteger("height");
                int i13 = (integer / widthAlignment) * widthAlignment;
                int i14 = (integer2 / heightAlignment) * heightAlignment;
                if (integer != i13 || integer2 != i14) {
                    mediaFormat.setInteger("width", i13);
                    mediaFormat.setInteger("height", i14);
                    LiteavLog.i(TAG, "updateMediaFormatWithAlignment,srcSize=(%d x %d),fixSize=(%d x %d),widthAlignment=%d,heightAlignment=%d", Integer.valueOf(integer), Integer.valueOf(integer2), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(widthAlignment), Integer.valueOf(heightAlignment));
                }
            }
        }
    }

    private void updateToCodecSupportSize(MediaFormat mediaFormat) {
        if (mediaFormat != null && LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            Pair<Integer, Integer> profileAndLevel = getProfileAndLevel(mediaFormat);
            int intValue = ((Integer) profileAndLevel.first).intValue();
            int intValue2 = ((Integer) profileAndLevel.second).intValue();
            updateMediaFormatToUpperSize(mediaFormat, intValue, intValue2);
            updateMediaFormatToLowerSize(mediaFormat, intValue, intValue2);
            updateMediaFormatWithAlignment(mediaFormat, intValue, intValue2);
        }
    }

    public MediaFormat build() {
        MediaFormat createBaseFormat = createBaseFormat();
        if (createBaseFormat == null) {
            return null;
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = getCodecCapabilities();
        if (codecCapabilities != null && LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
            setComplexity(createBaseFormat, codecCapabilities);
            if (this.mUseProfileAndLevel) {
                VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
                setProfileAndLevel(createBaseFormat, codecCapabilities, getMediaCodecProfile(videoEncodeParams.encoderProfile, videoEncodeParams.codecType == CodecType.H265));
            }
            if (this.mEnableSetBitrateModeIfSupport) {
                setBitrateModeIfDeviceSupport(createBaseFormat, codecCapabilities, getMediaCodecBitrateMode(this.mVideoEncodeParams.bitrateMode));
            }
        }
        MediaCodecInfo.CodecCapabilities createCodecCapabilities = createCodecCapabilities(createBaseFormat);
        if (createCodecCapabilities != null) {
            codecCapabilities = createCodecCapabilities;
        }
        updateBitRateFromSupportRange(createBaseFormat, codecCapabilities);
        updateToCodecSupportSize(createBaseFormat);
        setDeviceRelatedParams(createBaseFormat);
        return createBaseFormat;
    }

    public MediaFormatBuilder enableSetBitrateModeIfSupport(boolean z11) {
        this.mEnableSetBitrateModeIfSupport = z11;
        return this;
    }

    public MediaFormatBuilder useProfileAndLevel(boolean z11) {
        this.mUseProfileAndLevel = z11;
        return this;
    }
}
