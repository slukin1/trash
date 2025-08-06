package com.tencent.live2.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef;

public class V2TXLiveUtils {
    private static final String TAG = "V2TXLiveUtils";
    public static final String TRTC_ADDRESS1 = new String(Base64.decode("cm9vbTovL2Nsb3VkLnRlbmNlbnQuY29tL3J0Yw==", 0));
    public static final String TRTC_ADDRESS2 = new String(Base64.decode("cm9vbTovL3J0Yy50ZW5jZW50LmNvbQ==", 0));

    /* renamed from: com.tencent.live2.impl.V2TXLiveUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22716a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution[] r0 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22716a = r0
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution160x160     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution270x270     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x480     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x240     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x360     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x480     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x180     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x270     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x360     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1280x720     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f22716a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution r1 = com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1920x1080     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.live2.impl.V2TXLiveUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f22717a;

        /* renamed from: b  reason: collision with root package name */
        public int f22718b;

        public a(int i11, int i12) {
            this.f22717a = i11;
            this.f22718b = i12;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r1 = 250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r1 = 350;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return new com.tencent.live2.impl.V2TXLiveUtils.a(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.live2.impl.V2TXLiveUtils.a getBitrateByResolution(com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution r7) {
        /*
            int[] r0 = com.tencent.live2.impl.V2TXLiveUtils.AnonymousClass1.f22716a
            int r7 = r7.ordinal()
            r7 = r0[r7]
            r0 = 900(0x384, float:1.261E-42)
            r1 = 600(0x258, float:8.41E-43)
            r2 = 400(0x190, float:5.6E-43)
            r3 = 250(0xfa, float:3.5E-43)
            r4 = 350(0x15e, float:4.9E-43)
            r5 = 1500(0x5dc, float:2.102E-42)
            r6 = 800(0x320, float:1.121E-42)
            switch(r7) {
                case 1: goto L_0x003e;
                case 2: goto L_0x0039;
                case 3: goto L_0x0035;
                case 4: goto L_0x0031;
                case 5: goto L_0x002e;
                case 6: goto L_0x0042;
                case 7: goto L_0x002c;
                case 8: goto L_0x0029;
                case 9: goto L_0x0026;
                case 10: goto L_0x0019;
                case 11: goto L_0x0021;
                case 12: goto L_0x001c;
                default: goto L_0x0019;
            }
        L_0x0019:
            r0 = r5
            r1 = r6
            goto L_0x0042
        L_0x001c:
            r1 = 2500(0x9c4, float:3.503E-42)
            r0 = 3000(0xbb8, float:4.204E-42)
            goto L_0x0042
        L_0x0021:
            r1 = 1000(0x3e8, float:1.401E-42)
            r0 = 1800(0x708, float:2.522E-42)
            goto L_0x0042
        L_0x0026:
            r1 = 500(0x1f4, float:7.0E-43)
            goto L_0x0042
        L_0x0029:
            r0 = 550(0x226, float:7.71E-43)
            goto L_0x0037
        L_0x002c:
            r0 = r2
            goto L_0x0033
        L_0x002e:
            r0 = r1
            r1 = r2
            goto L_0x0042
        L_0x0031:
            r0 = 375(0x177, float:5.25E-43)
        L_0x0033:
            r1 = r3
            goto L_0x0042
        L_0x0035:
            r0 = 525(0x20d, float:7.36E-43)
        L_0x0037:
            r1 = r4
            goto L_0x0042
        L_0x0039:
            r1 = 200(0xc8, float:2.8E-43)
            r0 = 300(0x12c, float:4.2E-43)
            goto L_0x0042
        L_0x003e:
            r1 = 100
            r0 = 150(0x96, float:2.1E-43)
        L_0x0042:
            com.tencent.live2.impl.V2TXLiveUtils$a r7 = new com.tencent.live2.impl.V2TXLiveUtils$a
            r7.<init>(r1, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.live2.impl.V2TXLiveUtils.getBitrateByResolution(com.tencent.live2.V2TXLiveDef$V2TXLiveVideoResolution):com.tencent.live2.impl.V2TXLiveUtils$a");
    }

    public static V2TXLiveDef.V2TXLiveMode parseLiveMode(String str) {
        if (str.startsWith("trtc://") || str.startsWith(TRTC_ADDRESS1) || str.startsWith(TRTC_ADDRESS2)) {
            TXCLog.i(TAG, "parseLiveMode: rtc.");
            return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
        }
        TXCLog.i(TAG, "parseLiveMode: rtmp.");
        return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
    }

    public static String removeURLSensitiveInfo(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String[] strArr = {"roomsig", "privatemapkey", "usersig"};
            for (int i11 = 0; i11 < 3; i11++) {
                if (str.contains(strArr[i11]) && (indexOf = str.indexOf(strArr[i11])) != -1) {
                    int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf);
                    if (indexOf2 == -1) {
                        str = str.substring(0, indexOf);
                    } else {
                        str = str.substring(0, indexOf) + str.substring(indexOf2);
                    }
                }
            }
        } catch (Exception e11) {
            TXCLog.e(TAG, "remove url sensitive info failed.", e11);
        }
        return str;
    }
}
