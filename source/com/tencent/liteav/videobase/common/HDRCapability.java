package com.tencent.liteav.videobase.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.l;

@JNINamespace("liteav::video")
public class HDRCapability {
    private static final String TAG = "HDRCapability";
    private static Boolean sIsHDR10Supported;
    private static final l sSequenceTaskRunner = new l();

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r1 == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        if (r2 == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1 = java.lang.Boolean.valueOf(r1);
        sIsHDR10Supported = r1;
        com.tencent.liteav.base.util.LiteavLog.i(TAG, "the device supports hdr10 %b", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0033, code lost:
        com.tencent.liteav.base.util.LiteavLog.e(TAG, "check hdr capability error ", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = isDisplaySupportHDR10();
        r2 = isDecoderSupportHDR10();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void checkIsHDR10Supported() {
        /*
            java.lang.Class<com.tencent.liteav.videobase.common.HDRCapability> r0 = com.tencent.liteav.videobase.common.HDRCapability.class
            monitor-enter(r0)
            java.lang.Boolean r1 = sIsHDR10Supported     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            boolean r1 = isDisplaySupportHDR10()     // Catch:{ all -> 0x0032 }
            boolean r2 = isDecoderSupportHDR10()     // Catch:{ all -> 0x0032 }
            monitor-enter(r0)     // Catch:{ all -> 0x0032 }
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x001b
            if (r2 == 0) goto L_0x001b
            r1 = r3
            goto L_0x001c
        L_0x001b:
            r1 = r4
        L_0x001c:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x002f }
            sIsHDR10Supported = r1     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "HDRCapability"
            java.lang.String r5 = "the device supports hdr10 %b"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x002f }
            r3[r4] = r1     // Catch:{ all -> 0x002f }
            com.tencent.liteav.base.util.LiteavLog.i(r2, r5, r3)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r1     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            java.lang.String r1 = "HDRCapability"
            java.lang.String r2 = "check hdr capability error "
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)
            return
        L_0x003b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.common.HDRCapability.checkIsHDR10Supported():void");
    }

    private static boolean hasHDR10ProfileLevel(MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr) {
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == 4096) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDecoderSupportHDR10() {
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            for (String contains : mediaCodecInfo.getSupportedTypes()) {
                if (contains.contains("video/hevc") && hasHDR10ProfileLevel(mediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDisplaySupportHDR10() {
        WindowManager windowManager;
        Display.HdrCapabilities hdrCapabilities;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (windowManager = (WindowManager) applicationContext.getSystemService("window")) == null || (hdrCapabilities = windowManager.getDefaultDisplay().getHdrCapabilities()) == null) {
            return false;
        }
        for (int i11 : hdrCapabilities.getSupportedHdrTypes()) {
            if (i11 == 2) {
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean isHDRSupported(int i11) {
        synchronized (HDRCapability.class) {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 24) {
                return false;
            }
            if (i11 != b.HDR10.mValue) {
                return false;
            }
            Boolean bool = sIsHDR10Supported;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            sSequenceTaskRunner.a(a.a());
            return false;
        }
    }
}
