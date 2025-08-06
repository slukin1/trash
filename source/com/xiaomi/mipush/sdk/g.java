package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gl;
import java.util.HashMap;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<d, a> f51315a = new HashMap<>();

    /* renamed from: com.xiaomi.mipush.sdk.g$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51316a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.xiaomi.mipush.sdk.d[] r0 = com.xiaomi.mipush.sdk.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51316a = r0
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_HUAWEI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51316a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FCM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f51316a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_COS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f51316a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xiaomi.mipush.sdk.d r1 = com.xiaomi.mipush.sdk.d.ASSEMBLE_PUSH_FTOS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.AnonymousClass1.<clinit>():void");
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f51317a;

        /* renamed from: b  reason: collision with root package name */
        public String f51318b;

        public a(String str, String str2) {
            this.f51317a = str;
            this.f51318b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            f51315a.put(dVar, aVar);
        }
    }

    public static a a(d dVar) {
        return f51315a.get(dVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gl m2361a(d dVar) {
        return gl.AggregatePushSwitch;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static v m2360a(d dVar) {
        int i11 = AnonymousClass1.f51316a[dVar.ordinal()];
        if (i11 == 1) {
            return v.UPLOAD_HUAWEI_TOKEN;
        }
        if (i11 == 2) {
            return v.UPLOAD_FCM_TOKEN;
        }
        if (i11 == 3) {
            return v.UPLOAD_COS_TOKEN;
        }
        if (i11 != 4) {
            return null;
        }
        return v.UPLOAD_FTOS_TOKEN;
    }
}
