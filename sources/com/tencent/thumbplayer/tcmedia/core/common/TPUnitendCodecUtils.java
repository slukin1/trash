package com.tencent.thumbplayer.tcmedia.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import java.util.HashMap;

public class TPUnitendCodecUtils {
    private static int DolbyVisionProfileDvavPen = 1;
    private static int DolbyVisionProfileDvavPer = 0;
    private static int DolbyVisionProfileDvavSe = 9;
    private static int DolbyVisionProfileDvheDen = 3;
    private static int DolbyVisionProfileDvheDer = 2;
    private static int DolbyVisionProfileDvheDtb = 7;
    private static int DolbyVisionProfileDvheDth = 6;
    private static int DolbyVisionProfileDvheDtr = 4;
    private static int DolbyVisionProfileDvheSt = 8;
    private static int DolbyVisionProfileDvheStn = 5;
    private static HashMap<String, String> mSecureDecoderNameMaps;

    public static int convertOmxProfileToDolbyVision(int i11) {
        int i12 = i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 8 ? i11 != 16 ? i11 != 32 ? i11 != 64 ? i11 != 128 ? i11 != 256 ? i11 != 512 ? 0 : DolbyVisionProfileDvavSe : DolbyVisionProfileDvheSt : DolbyVisionProfileDvheDtb : DolbyVisionProfileDvheDth : DolbyVisionProfileDvheStn : DolbyVisionProfileDvheDtr : DolbyVisionProfileDvheDen : DolbyVisionProfileDvheDer : DolbyVisionProfileDvavPen : DolbyVisionProfileDvavPer;
        TPNativeLog.printLog(2, "TPUnitendCodecUtils", "convertOmxProfileToDolbyVision omxProfile:" + i11 + " dolbyVisionProfile:" + i12);
        return i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        return r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getDolbyVisionDecoderName(java.lang.String r16, int r17, int r18, boolean r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r19
            java.lang.Class<com.tencent.thumbplayer.tcmedia.core.common.TPUnitendCodecUtils> r3 = com.tencent.thumbplayer.tcmedia.core.common.TPUnitendCodecUtils.class
            monitor-enter(r3)
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = android.text.TextUtils.equals(r4, r0)     // Catch:{ all -> 0x00ca }
            r5 = 0
            if (r4 != 0) goto L_0x0014
            monitor-exit(r3)
            return r5
        L_0x0014:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00ca }
            r6 = 21
            if (r4 >= r6) goto L_0x001c
            monitor-exit(r3)
            return r5
        L_0x001c:
            android.media.MediaCodecList r4 = new android.media.MediaCodecList     // Catch:{ all -> 0x00ca }
            r6 = 1
            r4.<init>(r6)     // Catch:{ all -> 0x00ca }
            android.media.MediaCodecInfo[] r4 = r4.getCodecInfos()     // Catch:{ all -> 0x00ca }
            if (r4 != 0) goto L_0x002a
            monitor-exit(r3)
            return r5
        L_0x002a:
            int r6 = r4.length     // Catch:{ all -> 0x00ca }
            r9 = r5
            r8 = 0
        L_0x002d:
            if (r8 >= r6) goto L_0x00c8
            r10 = r4[r8]     // Catch:{ all -> 0x00ca }
            java.lang.String r11 = "TPUnitendCodecUtils"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = "getDolbyVisionDecoderName name:"
            r12.<init>(r13)     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = r10.getName()     // Catch:{ all -> 0x00ca }
            r12.append(r13)     // Catch:{ all -> 0x00ca }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00ca }
            r13 = 2
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r13, r11, r12)     // Catch:{ all -> 0x00ca }
            boolean r11 = r10.isEncoder()     // Catch:{ all -> 0x00ca }
            if (r11 != 0) goto L_0x00c3
            android.media.MediaCodecInfo$CodecCapabilities r11 = r10.getCapabilitiesForType(r0)     // Catch:{ Exception -> 0x0054 }
            goto L_0x0055
        L_0x0054:
            r11 = r5
        L_0x0055:
            if (r11 == 0) goto L_0x00c3
            android.media.MediaCodecInfo$CodecProfileLevel[] r12 = r11.profileLevels     // Catch:{ all -> 0x00ca }
            r14 = 0
        L_0x005a:
            int r15 = r12.length     // Catch:{ all -> 0x00ca }
            if (r14 >= r15) goto L_0x00b4
            r15 = r12[r14]     // Catch:{ all -> 0x00ca }
            int r15 = r15.profile     // Catch:{ all -> 0x00ca }
            int r15 = convertOmxProfileToDolbyVision(r15)     // Catch:{ all -> 0x00ca }
            if (r15 != r1) goto L_0x00af
            java.lang.String r5 = "TPUnitendCodecUtils"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = "getDolbyVisionDecoderName i:"
            r7.<init>(r13)     // Catch:{ all -> 0x00ca }
            r7.append(r14)     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = " profile:"
            r7.append(r13)     // Catch:{ all -> 0x00ca }
            r7.append(r15)     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = " dvProfile:"
            r7.append(r13)     // Catch:{ all -> 0x00ca }
            r7.append(r1)     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = " bSecure:"
            r7.append(r13)     // Catch:{ all -> 0x00ca }
            r7.append(r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = " name:"
            r7.append(r13)     // Catch:{ all -> 0x00ca }
            java.lang.String r13 = r10.getName()     // Catch:{ all -> 0x00ca }
            r7.append(r13)     // Catch:{ all -> 0x00ca }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00ca }
            r13 = 2
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r13, r5, r7)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x00a9
            java.lang.String r5 = "secure-playback"
            boolean r5 = r11.isFeatureSupported(r5)     // Catch:{ all -> 0x00ca }
            if (r5 == 0) goto L_0x00af
        L_0x00a9:
            java.lang.String r5 = r10.getName()     // Catch:{ all -> 0x00ca }
            r9 = r5
            goto L_0x00b4
        L_0x00af:
            int r14 = r14 + 1
            r5 = 0
            r13 = 2
            goto L_0x005a
        L_0x00b4:
            if (r9 == 0) goto L_0x00c3
            java.lang.String r0 = "TPUnitendCodecUtils"
            java.lang.String r1 = "getDolbyVisionDecoderName name:"
            java.lang.String r1 = r1.concat(r9)     // Catch:{ all -> 0x00ca }
            r2 = 2
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r2, r0, r1)     // Catch:{ all -> 0x00ca }
            goto L_0x00c8
        L_0x00c3:
            int r8 = r8 + 1
            r5 = 0
            goto L_0x002d
        L_0x00c8:
            monitor-exit(r3)
            return r9
        L_0x00ca:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPUnitendCodecUtils.getDolbyVisionDecoderName(java.lang.String, int, int, boolean):java.lang.String");
    }

    public static synchronized String getSecureDecoderName(String str) {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        synchronized (TPUnitendCodecUtils.class) {
            String str2 = null;
            if (!TextUtils.equals("video/avc", str) && !TextUtils.equals("video/hevc", str) && !TextUtils.equals("video/dolby-vision", str)) {
                return null;
            }
            if (mSecureDecoderNameMaps == null) {
                mSecureDecoderNameMaps = new HashMap<>();
            }
            if (mSecureDecoderNameMaps.containsKey(str)) {
                String str3 = mSecureDecoderNameMaps.get(str);
                return str3;
            }
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            if (codecInfos == null) {
                return null;
            }
            int length = codecInfos.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo = codecInfos[i11];
                if (!mediaCodecInfo.isEncoder()) {
                    try {
                        codecCapabilities = mediaCodecInfo.getCapabilitiesForType(str);
                    } catch (Exception unused) {
                        codecCapabilities = null;
                    }
                    if (codecCapabilities == null) {
                        continue;
                    } else if (codecCapabilities.isFeatureSupported("secure-playback")) {
                        str2 = mediaCodecInfo.getName();
                        break;
                    }
                }
                i11++;
            }
            mSecureDecoderNameMaps.put(str, str2);
            return str2;
        }
    }
}
