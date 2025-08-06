package com.huawei.hms.hatool;

import android.util.Pair;
import java.util.List;
import java.util.Map;

public class k extends u0 {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38203a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huawei.hms.hatool.d0[] r0 = com.huawei.hms.hatool.d0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f38203a = r0
                com.huawei.hms.hatool.d0 r1 = com.huawei.hms.hatool.d0.SN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f38203a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.hatool.d0 r1 = com.huawei.hms.hatool.d0.IMEI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f38203a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.hatool.d0 r1 = com.huawei.hms.hatool.d0.UDID     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.k.a.<clinit>():void");
        }
    }

    public static f0 a(String str, String str2, String str3, String str4) {
        f0 a11 = u0.a(str, str2, str3, str4);
        String a12 = j.a().a(a1.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String b11 = hg.a.b(q0.f() + a12 + currentTimeMillis);
        a11.f(String.valueOf(currentTimeMillis));
        a11.g(b11);
        return a11;
    }

    public static h1 a(List<b1> list, String str, String str2, String str3, String str4) {
        v.c("hmsSdk", "generate UploadData");
        h1 b11 = u0.b(str, str2);
        if (b11 == null) {
            return null;
        }
        b11.a((k0) a(m1.d().a(), str, str2, str3));
        b11.a(a(str, str2));
        b11.a((t0) a(str2, str, str4));
        b11.a(a1.g(str, str2));
        b11.a(list);
        return b11;
    }

    public static l a(String str, String str2) {
        l a11 = u0.a(str, str2);
        i c11 = j.a().c(str, str2);
        a11.g(j.a().a(a1.c(str, str2)));
        a11.f(a1.o(str, str2));
        a11.c(j.a().f(str, str2));
        int i11 = a.f38203a[c11.a().ordinal()];
        if (i11 == 1) {
            a11.d(c11.b());
        } else if (i11 == 2) {
            a11.b(c11.b());
        } else if (i11 == 3) {
            a11.e(c11.b());
        }
        return a11;
    }

    public static y0 a(String str, String str2, String str3) {
        y0 a11 = u0.a(str, str2, str3);
        Pair<String, String> e11 = j.a().e(str2, str);
        a11.f((String) e11.first);
        a11.g((String) e11.second);
        a11.h(o.b());
        a11.d(j.a().d(str2, str));
        return a11;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c11 = u0.c(str, str3);
        Map<String, String> i11 = a1.i(str, str2);
        if (i11 == null) {
            return c11;
        }
        c11.putAll(i11);
        return c11;
    }
}
