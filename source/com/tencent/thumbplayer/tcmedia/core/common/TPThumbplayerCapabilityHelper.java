package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;
import android.os.Build;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability;
import java.util.HashMap;

public class TPThumbplayerCapabilityHelper {
    public static boolean addACodecBlacklist(int i11, int i12, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange) {
        return TPPlayerDecoderCapability.addACodecBlacklist(i11, i12, tPACodecPropertyRange);
    }

    public static boolean addACodecWhitelist(int i11, int i12, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange) {
        return TPPlayerDecoderCapability.addACodecWhitelist(i11, i12, tPACodecPropertyRange);
    }

    public static boolean addDRMLevel1Blacklist(int i11) {
        return TPPlayerDecoderCapability.addDRMLevel1Blacklist(i11);
    }

    public static boolean addHDRBlackList(int i11, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPPlayerDecoderCapability.addHDRBlackList(i11, tPHdrSupportVersionRange);
    }

    public static boolean addHDRVideoDecoderTypeWhiteList(int i11, int i12, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPPlayerDecoderCapability.addHDRVideoDecoderTypeWhiteList(i11, i12, tPHdrSupportVersionRange);
    }

    public static boolean addHDRWhiteList(int i11, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPPlayerDecoderCapability.addHDRWhiteList(i11, tPHdrSupportVersionRange);
    }

    public static boolean addVCodecBlacklist(int i11, int i12, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        return TPPlayerDecoderCapability.addVCodecBlacklist(i11, i12, tPVCodecPropertyRange);
    }

    public static boolean addVCodecWhitelist(int i11, int i12, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        return TPPlayerDecoderCapability.addVCodecWhitelist(i11, i12, tPVCodecPropertyRange);
    }

    public static int[] getDRMCapabilities() {
        return TPDrm.getDRMCapabilities();
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int i11) {
        return TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        r4 = r2.get(java.lang.Integer.valueOf(r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability.TPCodecMaxCapability getVCodecMaxCapability(int r4) {
        /*
            com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPCodecMaxCapability r0 = new com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPCodecMaxCapability
            r1 = 0
            r2 = 30
            r0.<init>(r1, r1, r1, r2)
            r1 = 102(0x66, float:1.43E-43)
            java.util.HashMap r1 = com.tencent.thumbplayer.tcmedia.core.common.TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(r1)
            r2 = 101(0x65, float:1.42E-43)
            java.util.HashMap r2 = com.tencent.thumbplayer.tcmedia.core.common.TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(r2)
            if (r1 == 0) goto L_0x0023
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            java.lang.Object r1 = r1.get(r3)
            com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPCodecMaxCapability r1 = (com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability.TPCodecMaxCapability) r1
            if (r1 == 0) goto L_0x0023
            r0 = r1
        L_0x0023:
            if (r2 == 0) goto L_0x0038
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPCodecMaxCapability r4 = (com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability.TPCodecMaxCapability) r4
            if (r4 == 0) goto L_0x0038
            int r1 = r4.maxLumaSamples
            int r2 = r0.maxLumaSamples
            if (r1 <= r2) goto L_0x0038
            r0 = r4
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPThumbplayerCapabilityHelper.getVCodecMaxCapability(int):com.tencent.thumbplayer.tcmedia.core.common.TPCodecCapability$TPCodecMaxCapability");
    }

    public static synchronized void init(Context context, boolean z11) {
        synchronized (TPThumbplayerCapabilityHelper.class) {
            TPPlayerDecoderCapability.init(context, z11);
        }
    }

    public static boolean isACodecCapabilityCanSupport(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (isACodecCapabilitySupport(1, i11, i12, i13, i14, i15, i16)) {
            return true;
        }
        return isACodecCapabilitySupport(102, i11, i12, i13, i14, i15, i16);
    }

    public static boolean isACodecCapabilitySupport(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return TPPlayerDecoderCapability.isACodecCapabilitySupport(i11, i12, i13, i14, i15, i16, i17);
    }

    public static boolean isDDPlusSupported() {
        return TPPlayerDecoderCapability.isDDPlusSupported();
    }

    public static boolean isDDSupported() {
        return TPPlayerDecoderCapability.isDDPlusSupported();
    }

    public static boolean isDRMsupport(int i11) {
        int[] dRMCapabilities = getDRMCapabilities();
        if (dRMCapabilities.length == 0) {
            return false;
        }
        for (int i12 : dRMCapabilities) {
            if (i11 == i12) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDolbyDSSupported() {
        return TPPlayerDecoderCapability.isDolbyDSSupported();
    }

    public static boolean isFeatureSupport(int i11) {
        return TPFeatureCapability.isFeatureSupport(i11);
    }

    public static boolean isHDRsupport(int i11, int i12, int i13) {
        return TPPlayerDecoderCapability.isHDRsupport(i11, i12, i13);
    }

    public static boolean isSupportMediaCodecRotateInternal() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNativeMediaCodec() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportSetOutputSurfaceApi() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static boolean isVCodecCapabilityCanSupport(int i11, int i12, int i13, int i14, int i15) {
        return isVCodecCapabilityCanSupport(i11, i12, i13, i14, i15, 30);
    }

    public static boolean isVCodecCapabilityCanSupport(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (isVCodecCapabilitySupport(101, i11, i12, i13, i14, i15, i16)) {
            return true;
        }
        return isVCodecCapabilitySupport(102, i11, i12, i13, i14, i15, i16);
    }

    @Deprecated
    public static boolean isVCodecCapabilitySupport(int i11, int i12, int i13, int i14, int i15, int i16) {
        return isVCodecCapabilitySupport(i11, i12, i13, i14, i15, i16, 30);
    }

    public static boolean isVCodecCapabilitySupport(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return TPPlayerDecoderCapability.isVCodecCapabilitySupport(i11, i12, i13, i14, i15, i16, i17);
    }

    public static void setMediaCodecPreferredSoftwareComponent(boolean z11) {
        TPPlayerDecoderCapability.setMediaCodecPreferredSoftwareComponent(z11);
    }
}
