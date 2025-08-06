package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.util.Pair;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f22656a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22657b = true;

    /* renamed from: c  reason: collision with root package name */
    private final MediaCodec f22658c;

    /* renamed from: d  reason: collision with root package name */
    private final String f22659d;

    /* renamed from: e  reason: collision with root package name */
    private final VideoEncodeParams f22660e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f22661f = null;

    /* renamed from: com.tencent.liteav.videoproducer.encoder.a$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22662a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f22663b;

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
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile[] r0 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22663b = r0
                r1 = 1
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r2 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_MAIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22663b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r3 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_HIGH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f22663b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r4 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.EncoderProfile.PROFILE_BASELINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode[] r3 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f22662a = r3
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r4 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.CBR     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f22662a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r3 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.VBR     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f22662a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r1 = com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.BitrateMode.CQ     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(MediaCodec mediaCodec, String str, VideoEncodeParams videoEncodeParams, Boolean bool) {
        this.f22658c = mediaCodec;
        this.f22659d = str;
        this.f22660e = videoEncodeParams;
        this.f22661f = bool;
    }

    private boolean a(int i11, MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        Boolean bool;
        if (i11 != 2 || (bool = this.f22661f) == null) {
            return encoderCapabilities.isBitrateModeSupported(i11);
        }
        return bool.booleanValue();
    }

    private static Pair<Integer, Integer> a(MediaFormat mediaFormat) {
        int i11;
        int i12 = 0;
        try {
            i11 = mediaFormat.getInteger(Scopes.PROFILE);
        } catch (Throwable th2) {
            LiteavLog.i("MediaFormatBuilder", "get profile fail.", th2);
            i11 = 0;
        }
        try {
            i12 = mediaFormat.getInteger(FirebaseAnalytics.Param.LEVEL);
        } catch (Throwable th3) {
            LiteavLog.i("MediaFormatBuilder", "get level fail.", th3);
        }
        return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
    }

    private MediaCodecInfo.VideoCapabilities a(int i11, int i12) {
        MediaCodecInfo.CodecCapabilities createFromProfileLevel;
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && (createFromProfileLevel = MediaCodecInfo.CodecCapabilities.createFromProfileLevel(this.f22659d, i11, i12)) != null) {
            return createFromProfileLevel.getVideoCapabilities();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.MediaFormat a() {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = "value"
            java.lang.String r3 = "key"
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r1.f22660e
            int r4 = r0.width
            java.lang.String r5 = "bitrate"
            r6 = 0
            if (r4 == 0) goto L_0x0050
            int r8 = r0.height
            if (r8 == 0) goto L_0x0050
            int r9 = r0.bitrate
            if (r9 == 0) goto L_0x0050
            int r0 = r0.fps
            if (r0 != 0) goto L_0x001c
            goto L_0x0050
        L_0x001c:
            java.lang.String r0 = r1.f22659d
            android.media.MediaFormat r0 = android.media.MediaFormat.createVideoFormat(r0, r4, r8)
            if (r0 != 0) goto L_0x0025
            goto L_0x0050
        L_0x0025:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r1.f22660e
            int r4 = r4.bitrate
            int r4 = r4 * 1024
            r0.setInteger(r5, r4)
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r1.f22660e
            int r4 = r4.fps
            java.lang.String r8 = "frame-rate"
            r0.setInteger(r8, r4)
            r4 = 2130708361(0x7f000789, float:1.701803E38)
            java.lang.String r8 = "color-format"
            r0.setInteger(r8, r4)
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r4 = r1.f22660e
            boolean r8 = r4.fullIFrame
            if (r8 == 0) goto L_0x0047
            r4 = 0
            goto L_0x0049
        L_0x0047:
            int r4 = r4.gop
        L_0x0049:
            java.lang.String r8 = "i-frame-interval"
            r0.setInteger(r8, r4)
            r4 = r0
            goto L_0x0051
        L_0x0050:
            r4 = r6
        L_0x0051:
            if (r4 != 0) goto L_0x0054
            return r6
        L_0x0054:
            int r0 = android.media.MediaCodecList.getCodecCount()
            r8 = 0
        L_0x0059:
            if (r8 >= r0) goto L_0x0084
            android.media.MediaCodecInfo r9 = android.media.MediaCodecList.getCodecInfoAt(r8)
            boolean r10 = r9.isEncoder()
            if (r10 == 0) goto L_0x0081
            java.lang.String[] r10 = r9.getSupportedTypes()
            int r11 = r10.length
            r12 = 0
        L_0x006b:
            if (r12 >= r11) goto L_0x0081
            r13 = r10[r12]
            java.lang.String r14 = r1.f22659d
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x007e
            java.lang.String r0 = r1.f22659d
            android.media.MediaCodecInfo$CodecCapabilities r0 = r9.getCapabilitiesForType(r0)
            goto L_0x0085
        L_0x007e:
            int r12 = r12 + 1
            goto L_0x006b
        L_0x0081:
            int r8 = r8 + 1
            goto L_0x0059
        L_0x0084:
            r0 = r6
        L_0x0085:
            r9 = 21
            r11 = 1
            r12 = 2
            if (r0 == 0) goto L_0x017d
            int r13 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            if (r13 < r9) goto L_0x017d
            android.media.MediaCodecInfo$EncoderCapabilities r13 = r0.getEncoderCapabilities()
            if (r13 == 0) goto L_0x00ac
            android.util.Range r13 = r13.getComplexityRange()
            if (r13 == 0) goto L_0x00ac
            java.lang.Comparable r13 = r13.getUpper()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            java.lang.String r14 = "complexity"
            r4.setInteger(r14, r13)
        L_0x00ac:
            boolean r13 = r1.f22657b
            if (r13 == 0) goto L_0x0124
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r13 = r1.f22660e
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$EncoderProfile r14 = r13.encoderProfile
            com.tencent.liteav.videobase.common.CodecType r13 = r13.codecType
            com.tencent.liteav.videobase.common.CodecType r15 = com.tencent.liteav.videobase.common.CodecType.H265
            if (r13 != r15) goto L_0x00bc
            r13 = r11
            goto L_0x00bd
        L_0x00bc:
            r13 = 0
        L_0x00bd:
            if (r13 == 0) goto L_0x00c6
            int r13 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            if (r13 < r9) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            if (r14 != 0) goto L_0x00ca
        L_0x00c8:
            r13 = r11
            goto L_0x00db
        L_0x00ca:
            int[] r13 = com.tencent.liteav.videoproducer.encoder.a.AnonymousClass1.f22663b
            int r14 = r14.ordinal()
            r13 = r13[r14]
            if (r13 == r11) goto L_0x00da
            if (r13 == r12) goto L_0x00d7
            goto L_0x00c8
        L_0x00d7:
            r13 = 8
            goto L_0x00db
        L_0x00da:
            r13 = r12
        L_0x00db:
            r15 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r6 = r1.f22659d
            java.lang.String r14 = "video/avc"
            boolean r6 = r6.equals(r14)
            if (r6 == 0) goto L_0x00ee
            r14 = 256(0x100, float:3.59E-43)
            r15 = 32768(0x8000, float:4.5918E-41)
            goto L_0x00f0
        L_0x00ee:
            r14 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00f0:
            android.media.MediaCodecInfo$CodecProfileLevel[] r6 = r0.profileLevels
            int r7 = r6.length
            r9 = 0
            r10 = 0
            r12 = 0
        L_0x00f6:
            if (r9 >= r7) goto L_0x0112
            r11 = r6[r9]
            int r8 = r11.level
            if (r8 < r14) goto L_0x010e
            int r11 = r11.profile
            if (r11 > r13) goto L_0x010e
            if (r11 > r10) goto L_0x0108
            if (r11 != r10) goto L_0x010e
            if (r8 <= r12) goto L_0x010e
        L_0x0108:
            int r8 = java.lang.Math.min(r8, r15)
            r12 = r8
            r10 = r11
        L_0x010e:
            int r9 = r9 + 1
            r11 = 1
            goto L_0x00f6
        L_0x0112:
            java.lang.String r6 = "profile"
            r4.setInteger(r6, r10)
            int r6 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r7 = 23
            if (r6 < r7) goto L_0x0124
            java.lang.String r6 = "level"
            r4.setInteger(r6, r12)
        L_0x0124:
            boolean r6 = r1.f22656a
            if (r6 == 0) goto L_0x017d
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r6 = r1.f22660e
            com.tencent.liteav.videoproducer.encoder.VideoEncoderDef$BitrateMode r6 = r6.bitrateMode
            if (r6 != 0) goto L_0x0130
        L_0x012e:
            r6 = 2
            goto L_0x0145
        L_0x0130:
            int[] r7 = com.tencent.liteav.videoproducer.encoder.a.AnonymousClass1.f22662a
            int r6 = r6.ordinal()
            r6 = r7[r6]
            r7 = 1
            if (r6 == r7) goto L_0x012e
            r7 = 2
            if (r6 == r7) goto L_0x0144
            r7 = 3
            if (r6 == r7) goto L_0x0142
            goto L_0x012e
        L_0x0142:
            r6 = 0
            goto L_0x0145
        L_0x0144:
            r6 = 1
        L_0x0145:
            android.media.MediaCodecInfo$EncoderCapabilities r7 = r0.getEncoderCapabilities()
            if (r7 == 0) goto L_0x017d
            boolean r8 = r1.a((int) r6, (android.media.MediaCodecInfo.EncoderCapabilities) r7)
            java.lang.String r9 = "bitrate-mode"
            if (r8 == 0) goto L_0x0157
            r4.setInteger(r9, r6)
            goto L_0x017d
        L_0x0157:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r6 = r1.f22660e
            boolean r6 = r6.fullIFrame
            if (r6 == 0) goto L_0x0173
            r6 = 1
            boolean r8 = r1.a((int) r6, (android.media.MediaCodecInfo.EncoderCapabilities) r7)
            if (r8 == 0) goto L_0x0168
            r4.setInteger(r9, r6)
            goto L_0x017d
        L_0x0168:
            r6 = 2
            boolean r7 = r1.a((int) r6, (android.media.MediaCodecInfo.EncoderCapabilities) r7)
            if (r7 == 0) goto L_0x017d
            r4.setInteger(r9, r6)
            goto L_0x017d
        L_0x0173:
            r6 = 2
            boolean r7 = r1.a((int) r6, (android.media.MediaCodecInfo.EncoderCapabilities) r7)
            if (r7 == 0) goto L_0x017d
            r4.setInteger(r9, r6)
        L_0x017d:
            int r6 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r7 = 23
            if (r6 >= r7) goto L_0x0187
            r6 = 0
            goto L_0x01a1
        L_0x0187:
            android.util.Pair r6 = a(r4)
            java.lang.Object r7 = r6.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.String r8 = r1.f22659d
            android.media.MediaCodecInfo$CodecCapabilities r6 = android.media.MediaCodecInfo.CodecCapabilities.createFromProfileLevel(r8, r7, r6)
        L_0x01a1:
            if (r6 == 0) goto L_0x01a4
            r0 = r6
        L_0x01a4:
            r6 = 4
            java.lang.String r7 = "MediaFormatBuilder"
            if (r0 == 0) goto L_0x01f5
            int r8 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r9 = 21
            if (r8 < r9) goto L_0x01f5
            android.media.MediaCodecInfo$VideoCapabilities r0 = r0.getVideoCapabilities()
            if (r0 == 0) goto L_0x01f5
            android.util.Range r0 = r0.getBitrateRange()
            int r8 = r4.getInteger(r5)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            java.lang.Comparable r9 = r0.clamp(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            java.lang.Comparable r11 = r0.getLower()
            r12 = 0
            r10[r12] = r11
            java.lang.Comparable r0 = r0.getUpper()
            r11 = 1
            r10[r11] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r11 = 2
            r10[r11] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r11 = 3
            r10[r11] = r0
            java.lang.String r0 = "bitrateRange=(%d, %d),bitrate=%d,clampBitrate=%d"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r0, r10)
            if (r8 == r9) goto L_0x01f5
            r4.setInteger(r5, r9)
        L_0x01f5:
            int r0 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r5 = 23
            if (r0 < r5) goto L_0x03fd
            android.util.Pair r0 = a(r4)
            java.lang.Object r5 = r0.first
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            android.media.MediaCodecInfo$VideoCapabilities r8 = r1.a((int) r5, (int) r0)
            r9 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r10 = "height"
            java.lang.String r11 = "width"
            if (r8 == 0) goto L_0x02b0
            android.util.Range r12 = r8.getSupportedWidths()
            android.util.Range r8 = r8.getSupportedHeights()
            if (r12 == 0) goto L_0x02b0
            if (r8 != 0) goto L_0x022b
            goto L_0x02b0
        L_0x022b:
            java.lang.Comparable r12 = r12.getUpper()
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Comparable r8 = r8.getUpper()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r13 = r4.getInteger(r11)
            int r14 = r4.getInteger(r10)
            if (r13 <= r14) goto L_0x024b
            int r15 = r12.intValue()
            int r6 = r8.intValue()
            if (r15 < r6) goto L_0x0257
        L_0x024b:
            if (r13 >= r14) goto L_0x0261
            int r6 = r12.intValue()
            int r15 = r8.intValue()
            if (r6 <= r15) goto L_0x0261
        L_0x0257:
            int r6 = r12.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r12 = r8
            r8 = r6
        L_0x0261:
            int r6 = r12.intValue()
            if (r6 < r13) goto L_0x026d
            int r6 = r8.intValue()
            if (r6 >= r14) goto L_0x02b0
        L_0x026d:
            int r6 = r12.intValue()
            float r6 = (float) r6
            float r15 = (float) r13
            float r17 = r15 * r9
            float r6 = r6 / r17
            int r9 = r8.intValue()
            float r9 = (float) r9
            r18 = r2
            float r2 = (float) r14
            r17 = 1065353216(0x3f800000, float:1.0)
            float r19 = r2 * r17
            float r9 = r9 / r19
            float r6 = java.lang.Math.min(r6, r9)
            float r15 = r15 * r6
            int r9 = (int) r15
            r4.setInteger(r11, r9)
            float r6 = r6 * r2
            int r2 = (int) r6
            r4.setInteger(r10, r2)
            r2 = 4
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r9 = 0
            r6[r9] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            r9 = 1
            r6[r9] = r2
            r2 = 2
            r6[r2] = r12
            r2 = 3
            r6[r2] = r8
            java.lang.String r2 = "updateMediaFormatToUpperSize:srcWidth=%d,srcHeight=%d,upperW=%d,upperH=%d"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r2, r6)
            goto L_0x02b2
        L_0x02b0:
            r18 = r2
        L_0x02b2:
            android.media.MediaCodecInfo$VideoCapabilities r2 = r1.a((int) r5, (int) r0)
            if (r2 == 0) goto L_0x0381
            android.util.Range r6 = r2.getSupportedWidths()
            android.util.Range r2 = r2.getSupportedHeights()
            if (r6 == 0) goto L_0x0381
            if (r2 != 0) goto L_0x02c6
            goto L_0x0381
        L_0x02c6:
            java.lang.Comparable r6 = r6.getLower()
            java.lang.Integer r6 = (java.lang.Integer) r6
            java.lang.Comparable r2 = r2.getLower()
            java.lang.Integer r2 = (java.lang.Integer) r2
            android.media.MediaCodec r8 = r1.f22658c
            if (r8 != 0) goto L_0x02d9
        L_0x02d6:
            r16 = 0
            goto L_0x02f7
        L_0x02d9:
            int r8 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r9 = 21
            if (r8 >= r9) goto L_0x02e2
            goto L_0x02d6
        L_0x02e2:
            android.media.MediaCodec r8 = r1.f22658c
            android.media.MediaCodecInfo r8 = r8.getCodecInfo()
            java.lang.String r9 = r1.f22659d
            android.media.MediaCodecInfo$CodecCapabilities r8 = r8.getCapabilitiesForType(r9)
            if (r8 != 0) goto L_0x02f1
            goto L_0x02d6
        L_0x02f1:
            android.media.MediaCodecInfo$VideoCapabilities r8 = r8.getVideoCapabilities()
            r16 = r8
        L_0x02f7:
            if (r16 == 0) goto L_0x0331
            android.util.Range r8 = r16.getSupportedWidths()
            android.util.Range r9 = r16.getSupportedHeights()
            if (r8 == 0) goto L_0x0331
            if (r9 == 0) goto L_0x0331
            int r6 = r6.intValue()
            java.lang.Comparable r8 = r8.getLower()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            int r6 = java.lang.Math.max(r6, r8)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r2 = r2.intValue()
            java.lang.Comparable r8 = r9.getLower()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            int r2 = java.lang.Math.max(r2, r8)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0331:
            int r8 = r6.intValue()
            if (r8 < 0) goto L_0x0381
            int r8 = r2.intValue()
            if (r8 >= 0) goto L_0x033e
            goto L_0x0381
        L_0x033e:
            int r8 = r4.getInteger(r11)
            int r9 = r4.getInteger(r10)
            int r12 = r6.intValue()
            if (r12 > r8) goto L_0x0352
            int r12 = r2.intValue()
            if (r12 <= r9) goto L_0x0381
        L_0x0352:
            int r12 = r6.intValue()
            float r12 = (float) r12
            float r8 = (float) r8
            r13 = 1065353216(0x3f800000, float:1.0)
            float r14 = r8 * r13
            float r12 = r12 / r14
            int r14 = r2.intValue()
            float r14 = (float) r14
            float r9 = (float) r9
            float r13 = r13 * r9
            float r14 = r14 / r13
            float r12 = java.lang.Math.max(r12, r14)
            float r8 = r8 * r12
            int r8 = (int) r8
            r4.setInteger(r11, r8)
            float r12 = r12 * r9
            int r8 = (int) r12
            r4.setInteger(r10, r8)
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]
            r8 = 0
            r9[r8] = r6
            r6 = 1
            r9[r6] = r2
            java.lang.String r2 = "updateMediaFormatToLowerSize:lowerW=%d,lowerH=%d"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r2, r9)
        L_0x0381:
            android.media.MediaCodecInfo$VideoCapabilities r0 = r1.a((int) r5, (int) r0)
            if (r0 == 0) goto L_0x03ff
            int r2 = r0.getWidthAlignment()
            int r0 = r0.getHeightAlignment()
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r9 = 0
            r6[r9] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r9 = 1
            r6[r9] = r8
            java.lang.String r8 = "widthAlignment=%d,heightAlignment=%d"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r8, r6)
            if (r2 < r5) goto L_0x03ff
            if (r0 < r5) goto L_0x03ff
            int r5 = r2 % 2
            if (r5 != 0) goto L_0x03ff
            int r5 = r0 % 2
            if (r5 == 0) goto L_0x03b2
            goto L_0x03ff
        L_0x03b2:
            int r5 = r4.getInteger(r11)
            int r6 = r4.getInteger(r10)
            int r8 = r5 / r2
            int r8 = r8 * r2
            int r9 = r6 / r0
            int r9 = r9 * r0
            if (r5 != r8) goto L_0x03c4
            if (r6 == r9) goto L_0x03ff
        L_0x03c4:
            r4.setInteger(r11, r8)
            r4.setInteger(r10, r9)
            r10 = 6
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r11 = 0
            r10[r11] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r6 = 1
            r10[r6] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
            r6 = 2
            r10[r6] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            r6 = 3
            r10[r6] = r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5 = 4
            r10[r5] = r2
            r2 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "updateMediaFormatWithAlignment,srcSize=(%d x %d),fixSize=(%d x %d),widthAlignment=%d,heightAlignment=%d"
            com.tencent.liteav.base.util.LiteavLog.i(r7, r0, r10)
            goto L_0x03ff
        L_0x03fd:
            r18 = r2
        L_0x03ff:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r1.f22660e
            org.json.JSONArray r0 = r0.mediaCodecDeviceRelatedParams
            if (r0 == 0) goto L_0x0470
            r12 = 0
        L_0x0406:
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r1.f22660e
            org.json.JSONArray r0 = r0.mediaCodecDeviceRelatedParams
            int r0 = r0.length()
            if (r12 >= r0) goto L_0x0470
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r1.f22660e     // Catch:{ all -> 0x0457 }
            org.json.JSONArray r0 = r0.mediaCodecDeviceRelatedParams     // Catch:{ all -> 0x0457 }
            org.json.JSONObject r0 = r0.getJSONObject(r12)     // Catch:{ all -> 0x0457 }
            java.lang.String r2 = "setDeviceRelatedParams,index=%d,key=%s,value=%d"
            r5 = 3
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0453 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0453 }
            r9 = 0
            r6[r9] = r8     // Catch:{ all -> 0x044f }
            java.lang.String r8 = r0.optString(r3)     // Catch:{ all -> 0x044f }
            r10 = 1
            r6[r10] = r8     // Catch:{ all -> 0x044b }
            r8 = r18
            int r11 = r0.optInt(r8)     // Catch:{ all -> 0x0449 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0449 }
            r13 = 2
            r6[r13] = r11     // Catch:{ all -> 0x0447 }
            com.tencent.liteav.base.util.LiteavLog.i(r7, r2, r6)     // Catch:{ all -> 0x0447 }
            java.lang.String r2 = r0.optString(r3)     // Catch:{ all -> 0x0447 }
            int r0 = r0.optInt(r8)     // Catch:{ all -> 0x0447 }
            r4.setInteger(r2, r0)     // Catch:{ all -> 0x0447 }
            goto L_0x046b
        L_0x0447:
            r0 = move-exception
            goto L_0x045e
        L_0x0449:
            r0 = move-exception
            goto L_0x045d
        L_0x044b:
            r0 = move-exception
            r8 = r18
            goto L_0x045d
        L_0x044f:
            r0 = move-exception
            r8 = r18
            goto L_0x045c
        L_0x0453:
            r0 = move-exception
            r8 = r18
            goto L_0x045b
        L_0x0457:
            r0 = move-exception
            r8 = r18
            r5 = 3
        L_0x045b:
            r9 = 0
        L_0x045c:
            r10 = 1
        L_0x045d:
            r13 = 2
        L_0x045e:
            java.lang.String r2 = java.lang.String.valueOf(r12)
            java.lang.String r6 = "set mediaCodec device related params failed,index="
            java.lang.String r2 = r6.concat(r2)
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r7, (java.lang.String) r2, (java.lang.Throwable) r0)
        L_0x046b:
            int r12 = r12 + 1
            r18 = r8
            goto L_0x0406
        L_0x0470:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.a.a():android.media.MediaFormat");
    }
}
