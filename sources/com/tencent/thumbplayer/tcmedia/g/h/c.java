package com.tencent.thumbplayer.tcmedia.g.h;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.thumbplayer.tcmedia.g.b.e;
import com.tencent.thumbplayer.tcmedia.g.b.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f49343a = {"csd-0", "csd-1", "csd-2"};

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49344b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49345c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f49346d;

    static {
        HashSet hashSet = new HashSet();
        f49346d = hashSet;
        hashSet.add("1601");
        hashSet.add("1713");
        hashSet.add("1714");
        hashSet.add("A10-70F");
        hashSet.add("A10-70L");
        hashSet.add("A1601");
        hashSet.add("A2016a40");
        hashSet.add("A7000-a");
        hashSet.add("A7000plus");
        hashSet.add("A7010a48");
        hashSet.add("A7020a48");
        hashSet.add("AquaPowerM");
        hashSet.add("ASUS_X00AD_2");
        hashSet.add("Aura_Note_2");
        hashSet.add("BLACK-1X");
        hashSet.add("BRAVIA_ATV2");
        hashSet.add("BRAVIA_ATV3_4K");
        hashSet.add("C1");
        hashSet.add("ComioS1");
        hashSet.add("CP8676_I02");
        hashSet.add("CPH1609");
        hashSet.add("CPY83_I00");
        hashSet.add("cv1");
        hashSet.add("cv3");
        hashSet.add("deb");
        hashSet.add("E5643");
        hashSet.add("ELUGA_A3_Pro");
        hashSet.add("ELUGA_Note");
        hashSet.add("ELUGA_Prim");
        hashSet.add("ELUGA_Ray_X");
        hashSet.add("EverStar_S");
        hashSet.add("F3111");
        hashSet.add("F3113");
        hashSet.add("F3116");
        hashSet.add("F3211");
        hashSet.add("F3213");
        hashSet.add("F3215");
        hashSet.add("F3311");
        hashSet.add("flo");
        hashSet.add("fugu");
        hashSet.add("GiONEE_CBL7513");
        hashSet.add("GiONEE_GBL7319");
        hashSet.add("GIONEE_GBL7360");
        hashSet.add("GIONEE_SWW1609");
        hashSet.add("GIONEE_SWW1627");
        hashSet.add("GIONEE_SWW1631");
        hashSet.add("GIONEE_WBL5708");
        hashSet.add("GIONEE_WBL7365");
        hashSet.add("GIONEE_WBL7519");
        hashSet.add("griffin");
        hashSet.add("htc_e56ml_dtul");
        hashSet.add("hwALE-H");
        hashSet.add("HWBLN-H");
        hashSet.add("HWCAM-H");
        hashSet.add("HWVNS-H");
        hashSet.add("HWWAS-H");
        hashSet.add("i9031");
        hashSet.add("iball8735_9806");
        hashSet.add("Infinix-X572");
        hashSet.add("iris60");
        hashSet.add("itel_S41");
        hashSet.add("j2xlteins");
        hashSet.add("JGZ");
        hashSet.add("K50a40");
        hashSet.add("kate");
        hashSet.add("l5460");
        hashSet.add("le_x6");
        hashSet.add("LS-5017");
        hashSet.add("M5c");
        hashSet.add("manning");
        hashSet.add("marino_f");
        hashSet.add("MEIZU_M5");
        hashSet.add("mh");
        hashSet.add("mido");
        hashSet.add("c");
        hashSet.add("namath");
        hashSet.add("nicklaus_f");
        hashSet.add("NX541J");
        hashSet.add("NX573J");
        hashSet.add("OnePlus5T");
        hashSet.add("p212");
        hashSet.add("P681");
        hashSet.add("P85");
        hashSet.add("panell_d");
        hashSet.add("panell_dl");
        hashSet.add("panell_ds");
        hashSet.add("panell_dt");
        hashSet.add("PB2-670M");
        hashSet.add("PGN528");
        hashSet.add("PGN610");
        hashSet.add("PGN611");
        hashSet.add("Phantom6");
        hashSet.add("Pixi4-7_3G");
        hashSet.add("Pixi5-10_4G");
        hashSet.add("PLE");
        hashSet.add("PRO7S");
        hashSet.add("Q350");
        hashSet.add("Q4260");
        hashSet.add("Q427");
        hashSet.add("Q4310");
        hashSet.add("Q5");
        hashSet.add("QM16XE_U");
        hashSet.add("QX1");
        hashSet.add("santoni");
        hashSet.add("Slate_Pro");
        hashSet.add("SVP-DTV15");
        hashSet.add("s905x018");
        hashSet.add("taido_row");
        hashSet.add("TB3-730F");
        hashSet.add("TB3-730X");
        hashSet.add("TB3-850F");
        hashSet.add("TB3-850M");
        hashSet.add("tcl_eu");
        hashSet.add("V1");
        hashSet.add("V23GB");
        hashSet.add("V5");
        hashSet.add("vernee_M5");
        hashSet.add("watson");
        hashSet.add("whyred");
        hashSet.add("woods_f");
        hashSet.add("woods_fn");
        hashSet.add("X3_HK");
        hashSet.add("XE2X");
        hashSet.add("XT1663");
        hashSet.add("Z12_PRO");
        hashSet.add("Z80");
    }

    public static int a(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static int a(f fVar, e eVar) {
        if (eVar.f49239i == -1) {
            return a(eVar.f49240j, eVar.f49232b, eVar.f49233c, fVar.f49247d);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < eVar.f49231a.size(); i12++) {
            i11 += eVar.f49231a.get(i12).length;
        }
        return eVar.f49239i + i11;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.lang.String r5, int r6, int r7, boolean r8) {
        /*
            r0 = -1
            if (r6 == r0) goto L_0x00a5
            if (r7 != r0) goto L_0x0007
            goto L_0x00a5
        L_0x0007:
            r5.hashCode()
            int r1 = r5.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x004d;
                case -1662541442: goto L_0x0042;
                case 1187890754: goto L_0x0037;
                case 1331836730: goto L_0x002c;
                case 1599127256: goto L_0x0021;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r5 = r0
            goto L_0x0057
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x001f
            goto L_0x0014
        L_0x001f:
            r5 = 5
            goto L_0x0057
        L_0x0021:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x002a
            goto L_0x0014
        L_0x002a:
            r5 = r2
            goto L_0x0057
        L_0x002c:
            java.lang.String r1 = "video/avc"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            r5 = r3
            goto L_0x0057
        L_0x0037:
            java.lang.String r1 = "video/mp4v-es"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0040
            goto L_0x0014
        L_0x0040:
            r5 = r4
            goto L_0x0057
        L_0x0042:
            java.lang.String r1 = "video/hevc"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x004b
            goto L_0x0014
        L_0x004b:
            r5 = 1
            goto L_0x0057
        L_0x004d:
            java.lang.String r1 = "video/3gpp"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            r5 = 0
        L_0x0057:
            switch(r5) {
                case 0: goto L_0x009f;
                case 1: goto L_0x009d;
                case 2: goto L_0x009f;
                case 3: goto L_0x005b;
                case 4: goto L_0x009f;
                case 5: goto L_0x009d;
                default: goto L_0x005a;
            }
        L_0x005a:
            return r0
        L_0x005b:
            java.lang.String r5 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getDeviceName()
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x009c
            java.lang.String r5 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getDeviceManufacturer()
            java.lang.String r1 = "Amazon"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x008e
            java.lang.String r5 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getDeviceName()
            java.lang.String r1 = "KFSOWI"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x009c
            java.lang.String r5 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getDeviceName()
            java.lang.String r1 = "AFTS"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x008e
            if (r8 == 0) goto L_0x008e
            goto L_0x009c
        L_0x008e:
            r5 = 16
            int r6 = a((int) r6, (int) r5)
            int r7 = a((int) r7, (int) r5)
            int r6 = r6 * r7
            int r6 = r6 * r5
            int r6 = r6 * r5
            goto L_0x00a0
        L_0x009c:
            return r0
        L_0x009d:
            int r6 = r6 * r7
            goto L_0x00a1
        L_0x009f:
            int r6 = r6 * r7
        L_0x00a0:
            r2 = r4
        L_0x00a1:
            int r6 = r6 * r3
            int r2 = r2 * r4
            int r6 = r6 / r2
            return r6
        L_0x00a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.g.h.c.a(java.lang.String, int, int, boolean):int");
    }

    public static String a(MediaCodec mediaCodec) {
        return Build.VERSION.SDK_INT >= 18 ? mediaCodec.getName() : "unknow-low-api-18";
    }

    public static ArrayList<byte[]> a(MediaFormat mediaFormat) {
        ArrayList<byte[]> arrayList = new ArrayList<>();
        int i11 = 0;
        while (true) {
            String[] strArr = f49343a;
            if (i11 >= strArr.length) {
                return arrayList;
            }
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(strArr[i11]);
            if (byteBuffer != null) {
                arrayList.add(byteBuffer.array());
            }
            i11++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() {
        /*
            java.lang.Class<com.tencent.thumbplayer.tcmedia.g.h.c> r0 = com.tencent.thumbplayer.tcmedia.g.h.c.class
            monitor-enter(r0)
            boolean r1 = f49344b     // Catch:{ all -> 0x008d }
            if (r1 != 0) goto L_0x0089
            java.lang.String r1 = "dangal"
            java.lang.String r2 = android.os.Build.DEVICE     // Catch:{ all -> 0x008d }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x008d }
            r3 = 1
            if (r1 != 0) goto L_0x006a
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x008d }
            r4 = 27
            if (r1 > r4) goto L_0x0020
            java.lang.String r5 = "HWEML"
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x008d }
            if (r5 != 0) goto L_0x006a
        L_0x0020:
            if (r1 >= r4) goto L_0x006c
            java.util.Set<java.lang.String> r1 = f49346d     // Catch:{ all -> 0x008d }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x002c
            f49345c = r3     // Catch:{ all -> 0x008d }
        L_0x002c:
            java.lang.String r1 = com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo.getDeviceName()     // Catch:{ all -> 0x008d }
            r2 = -1
            int r4 = r1.hashCode()     // Catch:{ all -> 0x008d }
            r5 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            r6 = 2
            if (r4 == r5) goto L_0x005a
            r5 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r4 == r5) goto L_0x0050
            r5 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r4 == r5) goto L_0x0046
            goto L_0x0063
        L_0x0046:
            java.lang.String r4 = "AFTN"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0063
            r2 = r3
            goto L_0x0063
        L_0x0050:
            java.lang.String r4 = "AFTA"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0063
            r2 = 0
            goto L_0x0063
        L_0x005a:
            java.lang.String r4 = "JSN-L21"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0063
            r2 = r6
        L_0x0063:
            if (r2 == 0) goto L_0x006a
            if (r2 == r3) goto L_0x006a
            if (r2 == r6) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            f49345c = r3     // Catch:{ all -> 0x008d }
        L_0x006c:
            boolean r1 = com.tencent.thumbplayer.tcmedia.g.h.b.a()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = "TUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "deviceNeedsSetOutputSurfaceWorkaround:"
            r2.<init>(r4)     // Catch:{ all -> 0x008d }
            boolean r4 = f49345c     // Catch:{ all -> 0x008d }
            r2.append(r4)     // Catch:{ all -> 0x008d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008d }
            com.tencent.thumbplayer.tcmedia.g.h.b.b(r1, r2)     // Catch:{ all -> 0x008d }
        L_0x0087:
            f49344b = r3     // Catch:{ all -> 0x008d }
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            boolean r0 = f49345c
            return r0
        L_0x008d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.g.h.c.a():boolean");
    }

    public static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 19 && c(codecCapabilities);
    }

    public static boolean a(String str) {
        return str.contains("video");
    }

    public static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 21 && d(codecCapabilities);
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }
}
