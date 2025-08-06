package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import com.adjust.sdk.Constants;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::video")
public class MediaCodecAbility {
    private static final String TAG = "MediaCodecAbility";

    public static int getMediaCodecDecoderSupportLowResolution() {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return 0;
        }
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = MediaCodec.createDecoderByType("video/avc").getCodecInfo().getCapabilitiesForType("video/avc");
            if (capabilitiesForType == null || (videoCapabilities = capabilitiesForType.getVideoCapabilities()) == null) {
                return 0;
            }
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
            if (supportedWidths != null) {
                if (supportedHeights != null) {
                    return Math.max(supportedWidths.getLower().intValue(), supportedHeights.getLower().intValue());
                }
            }
            return 0;
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "get low resolution error:".concat(String.valueOf(th2)));
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        com.tencent.liteav.base.util.LiteavLog.i(TAG, "got hevc decoder:%s", r7.getName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isDecoderSupportHevc() {
        /*
            java.lang.String r0 = "MediaCodecAbility"
            int r1 = com.tencent.liteav.base.system.LiteavSystemInfo.getSystemOSVersionInt()
            r2 = 0
            r3 = 21
            if (r1 >= r3) goto L_0x000c
            return r2
        L_0x000c:
            r1 = 1
            android.media.MediaCodecList r3 = new android.media.MediaCodecList     // Catch:{ all -> 0x004f }
            r3.<init>(r2)     // Catch:{ all -> 0x004f }
            android.media.MediaCodecInfo[] r3 = r3.getCodecInfos()     // Catch:{ all -> 0x004f }
            int r4 = r3.length     // Catch:{ all -> 0x004f }
            r5 = r2
            r6 = r5
        L_0x0019:
            if (r5 >= r4) goto L_0x005f
            r7 = r3[r5]     // Catch:{ all -> 0x004d }
            java.lang.String[] r8 = r7.getSupportedTypes()     // Catch:{ all -> 0x004d }
            boolean r9 = r7.isEncoder()     // Catch:{ all -> 0x004d }
            if (r9 != 0) goto L_0x004a
            int r9 = r8.length     // Catch:{ all -> 0x004d }
            r10 = r2
        L_0x0029:
            if (r10 >= r9) goto L_0x004a
            r11 = r8[r10]     // Catch:{ all -> 0x004d }
            java.lang.String r12 = "video/hevc"
            boolean r11 = r11.contains(r12)     // Catch:{ all -> 0x004d }
            if (r11 == 0) goto L_0x0047
            java.lang.String r6 = "got hevc decoder:%s"
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ all -> 0x0044 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0044 }
            r8[r2] = r7     // Catch:{ all -> 0x0044 }
            com.tencent.liteav.base.util.LiteavLog.i(r0, r6, r8)     // Catch:{ all -> 0x0044 }
            r6 = r1
            goto L_0x004a
        L_0x0044:
            r2 = move-exception
            r6 = r1
            goto L_0x0052
        L_0x0047:
            int r10 = r10 + 1
            goto L_0x0029
        L_0x004a:
            int r5 = r5 + 1
            goto L_0x0019
        L_0x004d:
            r2 = move-exception
            goto L_0x0052
        L_0x004f:
            r1 = move-exception
            r6 = r2
            r2 = r1
        L_0x0052:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "get hevc decode error:"
            java.lang.String r1 = r2.concat(r1)
            com.tencent.liteav.base.util.LiteavLog.e(r0, r1)
        L_0x005f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.common.MediaCodecAbility.isDecoderSupportHevc():boolean");
    }

    public static boolean isEncoderSupportHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (mediaCodecInfo.isEncoder()) {
                    for (String contains : mediaCodecInfo.getSupportedTypes()) {
                        if (contains.contains("video/hevc")) {
                            LiteavLog.i(TAG, "get hevc encoder");
                            return true;
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th2) {
            LiteavLog.w(TAG, "failed to get hevc encoder:".concat(String.valueOf(th2)));
        }
        LiteavLog.w(TAG, "not got hevc encoder");
        return false;
    }

    public static boolean isMediaCodecDecodeSupportSWHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (!mediaCodecInfo.isEncoder()) {
                    int length = supportedTypes.length;
                    int i11 = 0;
                    while (i11 < length) {
                        if (!supportedTypes[i11].contains("video/hevc") || !isSoftOnlyDecoder(mediaCodecInfo)) {
                            i11++;
                        } else {
                            LiteavLog.i(TAG, "got soft only hevc decoder:%s", mediaCodecInfo.getName());
                            return true;
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "get hevc decode error:".concat(String.valueOf(th2)));
        }
        return false;
    }

    public static boolean isSoftOnlyDecoder(MediaCodecInfo mediaCodecInfo) {
        if (LiteavSystemInfo.getSystemOSVersionInt() > 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        return mediaCodecInfo.getName().contains("android") || mediaCodecInfo.getName().contains(Constants.REFERRER_API_GOOGLE);
    }
}
