package com.tencent.liteav.videobase.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f22242a;

    /* renamed from: b  reason: collision with root package name */
    public int f22243b;

    /* renamed from: c  reason: collision with root package name */
    public String f22244c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22245d;

    /* renamed from: e  reason: collision with root package name */
    private a f22246e;

    /* renamed from: f  reason: collision with root package name */
    private MediaFormat f22247f;

    /* renamed from: g  reason: collision with root package name */
    private JSONArray f22248g;

    /* renamed from: com.tencent.liteav.videobase.utils.c$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22249a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.liteav.videobase.utils.c$a[] r0 = com.tencent.liteav.videobase.utils.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22249a = r0
                com.tencent.liteav.videobase.utils.c$a r1 = com.tencent.liteav.videobase.utils.c.a.kQcom     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22249a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videobase.utils.c$a r1 = com.tencent.liteav.videobase.utils.c.a.kHisi     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22249a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.videobase.utils.c$a r1 = com.tencent.liteav.videobase.utils.c.a.kExynos     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22249a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.liteav.videobase.utils.c$a r1 = com.tencent.liteav.videobase.utils.c.a.kAmlogic     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videobase.utils.c.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        kUnKnown,
        kQcom,
        kHisi,
        kExynos,
        kAmlogic
    }

    public c() {
        a aVar = a.kUnKnown;
        this.f22246e = aVar;
        a b11 = b();
        if (b11 == aVar) {
            String lowerCase = LiteavSystemInfo.getHardware().toLowerCase();
            if (lowerCase.contains("qcom")) {
                aVar = a.kQcom;
            } else if (lowerCase.contains("kirin")) {
                aVar = a.kHisi;
            } else if (lowerCase.contains("exynos")) {
                aVar = a.kExynos;
            }
            b11 = aVar;
        }
        this.f22246e = b11;
        LiteavLog.i("HardwareDecoderMediaFormatBuilder", "hardware name:" + LiteavSystemInfo.getHardware().toLowerCase() + " chip brand:" + this.f22246e);
    }

    private static a b() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return a.kUnKnown;
        }
        try {
            int i11 = 0;
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            int length = codecInfos.length;
            while (i11 < length) {
                String lowerCase = codecInfos[i11].getName().toLowerCase();
                if (lowerCase.contains("hisi")) {
                    return a.kHisi;
                }
                if (lowerCase.contains("amlogic")) {
                    return a.kAmlogic;
                }
                if (!lowerCase.contains("qcom")) {
                    if (!lowerCase.contains("qti")) {
                        i11++;
                    }
                }
                return a.kQcom;
            }
        } catch (Throwable th2) {
            LiteavLog.e("HardwareDecoderMediaFormatBuilder", "get mediacode info error:" + th2.getMessage());
        }
        return a.kUnKnown;
    }

    public final MediaFormat a() {
        MediaFormat mediaFormat = this.f22247f;
        if (mediaFormat == null) {
            mediaFormat = MediaFormat.createVideoFormat(this.f22244c, this.f22242a, this.f22243b);
        }
        if (this.f22245d) {
            int systemOSVersionInt = LiteavSystemInfo.getSystemOSVersionInt();
            if (systemOSVersionInt >= 30 && this.f22246e != a.kHisi) {
                mediaFormat.setInteger("low-latency", 1);
            }
            if (systemOSVersionInt > 23 || !LiteavSystemInfo.getManufacturer().toLowerCase().contains("xiaomi")) {
                mediaFormat.setInteger("vdec-lowlatency", 1);
            }
            if (systemOSVersionInt >= 26) {
                int i11 = AnonymousClass1.f22249a[this.f22246e.ordinal()];
                if (i11 == 1) {
                    mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
                    mediaFormat.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
                } else if (i11 == 2) {
                    mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                    mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
                } else if (i11 == 3) {
                    mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
                } else if (i11 == 4) {
                    mediaFormat.setInteger("vendor.low-latency.enable", 1);
                }
            }
        }
        JSONArray jSONArray = this.f22248g;
        if (jSONArray != null) {
            int i12 = 0;
            while (i12 < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i12);
                    mediaFormat.setInteger(jSONObject.optString("key"), jSONObject.optInt("value"));
                    i12++;
                } catch (JSONException e11) {
                    LiteavLog.e("HardwareDecoderMediaFormatBuilder", "set MediaCodec device related params failed.", (Throwable) e11);
                }
            }
        }
        return mediaFormat;
    }
}
