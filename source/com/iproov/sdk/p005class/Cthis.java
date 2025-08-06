package com.iproov.sdk.p005class;

import android.os.Build;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import java.util.HashMap;

/* renamed from: com.iproov.sdk.class.this  reason: invalid class name and invalid package */
class Cthis {

    /* renamed from: do  reason: not valid java name */
    private static final HashMap<String, Integer> f207do;

    /* renamed from: for  reason: not valid java name */
    private static final HashMap<String, Integer> f208for;

    /* renamed from: if  reason: not valid java name */
    private static final HashMap<String, Integer> f209if;

    /* renamed from: new  reason: not valid java name */
    private static final HashMap<String, Integer> f210new;

    /* renamed from: com.iproov.sdk.class.this$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f211do;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.iproov.sdk.class.else[] r0 = com.iproov.sdk.p005class.Celse.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f211do = r0
                com.iproov.sdk.class.else r1 = com.iproov.sdk.p005class.Celse.AVC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f211do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.class.else r1 = com.iproov.sdk.p005class.Celse.HEVC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f211do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.class.else r1 = com.iproov.sdk.p005class.Celse.VP9     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f211do     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.iproov.sdk.class.else r1 = com.iproov.sdk.p005class.Celse.VP8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p005class.Cthis.Cdo.<clinit>():void");
        }
    }

    static {
        int i11;
        Integer num;
        HashMap<String, Integer> hashMap = new HashMap<>();
        f207do = hashMap;
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        f209if = hashMap2;
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        f208for = hashMap3;
        HashMap<String, Integer> hashMap4 = new HashMap<>();
        f210new = hashMap4;
        hashMap.put("AVCProfileBaseline", 1);
        hashMap.put("AVCProfileMain", 2);
        hashMap.put("AVCProfileExtended", 4);
        hashMap.put("AVCProfileHigh", 8);
        hashMap.put("AVCProfileHigh10", 16);
        hashMap.put("AVCProfileHigh422", 32);
        hashMap.put("AVCProfileHigh444", 64);
        hashMap.put("AVCLevel1", 1);
        hashMap.put("AVCLevel1b", 2);
        hashMap.put("AVCLevel11", 4);
        hashMap.put("AVCLevel12", 8);
        hashMap.put("AVCLevel13", 16);
        hashMap.put("AVCLevel2", 32);
        hashMap.put("AVCLevel21", 64);
        hashMap.put("AVCLevel22", 128);
        hashMap.put("AVCLevel3", 256);
        hashMap.put("AVCLevel31", 512);
        hashMap.put("AVCLevel32", 1024);
        HashMap<String, Integer> hashMap5 = hashMap4;
        hashMap.put("AVCLevel4", 2048);
        hashMap.put("AVCLevel41", 4096);
        HashMap<String, Integer> hashMap6 = hashMap3;
        hashMap.put("AVCLevel42", 8192);
        hashMap.put("AVCLevel5", 16384);
        hashMap.put("AVCLevel51", 32768);
        hashMap.put("AVCLevel52", 65536);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 27) {
            hashMap.put("AVCProfileConstrainedBaseline", 65536);
            i11 = i12;
            hashMap.put("AVCProfileConstrainedHigh", 524288);
        } else {
            i11 = i12;
        }
        hashMap2.put("HEVCMainTierLevel1", 1);
        hashMap2.put("HEVCMainTierLevel2", 4);
        hashMap2.put("HEVCHighTierLevel2", 8);
        hashMap2.put("HEVCMainTierLevel21", 16);
        hashMap2.put("HEVCHighTierLevel21", 32);
        hashMap2.put("HEVCMainTierLevel3", 64);
        hashMap2.put("HEVCHighTierLevel3", 128);
        hashMap2.put("HEVCMainTierLevel31", 256);
        hashMap2.put("HEVCHighTierLevel31", 512);
        hashMap2.put("HEVCMainTierLevel4", 1024);
        hashMap2.put("HEVCHighTierLevel4", 2048);
        hashMap2.put("HEVCMainTierLevel41", 4096);
        hashMap2.put("HEVCHighTierLevel41", 8192);
        hashMap2.put("HEVCMainTierLevel5", 16384);
        hashMap2.put("HEVCHighTierLevel5", 32768);
        hashMap2.put("HEVCMainTierLevel51", 65536);
        hashMap2.put("HEVCMainTierLevel52", 262144);
        hashMap2.put("HEVCHighTierLevel52", 524288);
        hashMap2.put("HEVCMainTierLevel6", 1048576);
        hashMap2.put("HEVCHighTierLevel6", 2097152);
        hashMap2.put("HEVCMainTierLevel61", 4194304);
        hashMap2.put("HEVCHighTierLevel61", 8388608);
        hashMap2.put("HEVCMainTierLevel62", 16777216);
        hashMap2.put("HEVCHighTierLevel62", Integer.valueOf(TPMediaCodecProfileLevel.HEVCHighTierLevel62));
        if (i11 >= 24) {
            HashMap<String, Integer> hashMap7 = hashMap6;
            hashMap7.put("VP9Profile0", 1);
            num = 2;
            hashMap7.put("VP9Profile1", 2);
            hashMap7.put("VP9Profile2", 4);
            hashMap7.put("VP9Profile3", 8);
            hashMap7.put("VP9Profile2HDR", 4096);
            hashMap7.put("VP9Profile3HDR", 8192);
            hashMap7.put("VP9Level1", 1);
            hashMap7.put("VP9Level11", 2);
            hashMap7.put("VP9Level2", 4);
            hashMap7.put("VP9Level21", 8);
            hashMap7.put("VP9Level3", 16);
            hashMap7.put("VP9Level31", 32);
            hashMap7.put("VP9Level4", 64);
            hashMap7.put("VP9Level41", 128);
            hashMap7.put("VP9Level5", 256);
            hashMap7.put("VP9Level51", 512);
            hashMap7.put("VP9Level6", 2048);
            hashMap7.put("VP9Level61", 4096);
            hashMap7.put("VP9Level62", 8192);
        } else {
            num = 2;
        }
        HashMap<String, Integer> hashMap8 = hashMap5;
        hashMap8.put("VP8ProfileMain", 1);
        hashMap8.put("VP8Level_Version0", 1);
        hashMap8.put("VP8Level_Version1", num);
        hashMap8.put("VP8Level_Version2", 4);
        hashMap8.put("VP8Level_Version3", 8);
    }

    /* renamed from: do  reason: not valid java name */
    public static Integer m287do(Celse elseR, String str) {
        int i11 = Cdo.f211do[elseR.ordinal()];
        if (i11 == 1) {
            return f207do.get(str);
        }
        if (i11 == 2) {
            return f209if.get(str);
        }
        if (i11 == 3) {
            return f208for.get(str);
        }
        if (i11 != 4) {
            return null;
        }
        return f210new.get(str);
    }
}
