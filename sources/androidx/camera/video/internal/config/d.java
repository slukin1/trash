package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoMimeInfo;
import androidx.camera.video.internal.encoder.j1;
import androidx.camera.video.r;
import androidx.camera.video.w1;
import androidx.core.util.h;
import c0.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Map<Integer, j1>> f6105a;

    static {
        HashMap hashMap = new HashMap();
        f6105a = hashMap;
        HashMap hashMap2 = new HashMap();
        j1 j1Var = j1.f6234a;
        hashMap2.put(1, j1Var);
        j1 j1Var2 = j1.f6236c;
        hashMap2.put(2, j1Var2);
        j1 j1Var3 = j1.f6237d;
        hashMap2.put(4096, j1Var3);
        hashMap2.put(8192, j1Var3);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(1, j1Var);
        hashMap3.put(2, j1Var2);
        hashMap3.put(4096, j1Var3);
        hashMap3.put(8192, j1Var3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(1, j1Var);
        hashMap4.put(4, j1Var2);
        hashMap4.put(4096, j1Var3);
        hashMap4.put(16384, j1Var3);
        hashMap4.put(2, j1Var);
        hashMap4.put(8, j1Var2);
        hashMap4.put(8192, j1Var3);
        hashMap4.put(32768, j1Var3);
        HashMap hashMap5 = new HashMap();
        hashMap5.put(256, j1Var2);
        hashMap5.put(512, j1.f6235b);
        hashMap.put("video/hevc", hashMap2);
        hashMap.put("video/av01", hashMap3);
        hashMap.put("video/x-vnd.on2.vp9", hashMap4);
        hashMap.put("video/dolby-vision", hashMap5);
    }

    public static String a(DynamicRange dynamicRange) {
        int encoding = dynamicRange.getEncoding();
        if (encoding == 1) {
            return "video/avc";
        }
        if (encoding == 3 || encoding == 4 || encoding == 5) {
            return "video/hevc";
        }
        if (encoding == 6) {
            return "video/dolby-vision";
        }
        throw new UnsupportedOperationException("Unsupported dynamic range: " + dynamicRange + "\nNo supported default mime type available.");
    }

    public static j1 b(String str, int i11) {
        j1 j1Var;
        Map map = f6105a.get(str);
        if (map != null && (j1Var = (j1) map.get(Integer.valueOf(i11))) != null) {
            return j1Var;
        }
        Logger.w("VideoConfigUtil", String.format("Unsupported mime type %s or profile level %d. Data space is unspecified.", new Object[]{str, Integer.valueOf(i11)}));
        return j1.f6234a;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [androidx.core.util.j] */
    /* JADX WARNING: type inference failed for: r9v1, types: [b0.f] */
    /* JADX WARNING: type inference failed for: r0v3, types: [b0.g] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.i1 c(androidx.camera.video.internal.config.VideoMimeInfo r16, androidx.camera.core.impl.Timebase r17, androidx.camera.video.w1 r18, android.util.Size r19, androidx.camera.core.DynamicRange r20, android.util.Range<java.lang.Integer> r21) {
        /*
            androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy r5 = r16.d()
            if (r5 == 0) goto L_0x001b
            b0.g r8 = new b0.g
            java.lang.String r1 = r16.a()
            r0 = r8
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r20
            r7 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x002f
        L_0x001b:
            b0.f r8 = new b0.f
            java.lang.String r10 = r16.a()
            r9 = r8
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r20
            r15 = r21
            r9.<init>(r10, r11, r12, r13, r14, r15)
        L_0x002f:
            java.lang.Object r0 = r8.get()
            androidx.camera.video.internal.encoder.i1 r0 = (androidx.camera.video.internal.encoder.i1) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.d.c(androidx.camera.video.internal.config.VideoMimeInfo, androidx.camera.core.impl.Timebase, androidx.camera.video.w1, android.util.Size, androidx.camera.core.DynamicRange, android.util.Range):androidx.camera.video.internal.encoder.i1");
    }

    public static VideoMimeInfo d(r rVar, DynamicRange dynamicRange, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        boolean isFullySpecified = dynamicRange.isFullySpecified();
        h.j(isFullySpecified, "Dynamic range must be a fully specified dynamic range [provided dynamic range: " + dynamicRange + "]");
        String h11 = r.h(rVar.c());
        if (videoValidatedEncoderProfilesProxy != null) {
            Set<Integer> c11 = a.c(dynamicRange);
            Set<Integer> b11 = a.b(dynamicRange);
            Iterator<EncoderProfilesProxy.VideoProfileProxy> it2 = videoValidatedEncoderProfilesProxy.getVideoProfiles().iterator();
            while (it2.hasNext()) {
                videoProfileProxy = it2.next();
                if (c11.contains(Integer.valueOf(videoProfileProxy.getHdrFormat())) && b11.contains(Integer.valueOf(videoProfileProxy.getBitDepth()))) {
                    String mediaType = videoProfileProxy.getMediaType();
                    if (Objects.equals(h11, mediaType)) {
                        Logger.d("VideoConfigUtil", "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + h11 + "]");
                    } else if (rVar.c() == -1) {
                        Logger.d("VideoConfigUtil", "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + h11 + ", dynamic range: " + dynamicRange + "]");
                    }
                    h11 = mediaType;
                    break;
                }
            }
        }
        videoProfileProxy = null;
        if (videoProfileProxy == null) {
            if (rVar.c() == -1) {
                h11 = a(dynamicRange);
            }
            if (videoValidatedEncoderProfilesProxy == null) {
                Logger.d("VideoConfigUtil", "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + h11 + ", dynamic range: " + dynamicRange + "]");
            } else {
                Logger.d("VideoConfigUtil", "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + h11 + ", dynamic range: " + dynamicRange + "]");
            }
        }
        VideoMimeInfo.Builder c12 = VideoMimeInfo.c(h11);
        if (videoProfileProxy != null) {
            c12.c(videoProfileProxy);
        }
        return c12.b();
    }

    public static int e(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, Range<Integer> range) {
        String str;
        Range<Integer> range2 = range;
        int doubleValue = (int) (((double) i11) * new Rational(i12, i13).doubleValue() * new Rational(i14, i15).doubleValue() * new Rational(i16, i17).doubleValue() * new Rational(i18, i19).doubleValue());
        if (Logger.isDebugEnabled("VideoConfigUtil")) {
            str = String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(doubleValue)});
        } else {
            str = "";
        }
        if (!w1.f6384b.equals(range2)) {
            doubleValue = range2.clamp(Integer.valueOf(doubleValue)).intValue();
            if (Logger.isDebugEnabled("VideoConfigUtil")) {
                str = str + String.format("\nClamped to range %s -> %dbps", new Object[]{range2, Integer.valueOf(doubleValue)});
            }
        }
        Logger.d("VideoConfigUtil", str);
        return doubleValue;
    }
}
