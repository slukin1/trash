package com.geetest.captcha;

public final class h {

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f65230a = new h((byte) 0);
    }

    public /* synthetic */ h(byte b11) {
        this();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:4|(3:6|7|8)|9|10|(1:14)|15|16|(3:18|19|(1:23))(1:24)|25|(1:27)|28|29|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[SYNTHETIC, Splitter:B:18:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[Catch:{ JSONException -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086 A[Catch:{ JSONException -> 0x00b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r9) {
        /*
            java.lang.String r0 = "$unknown"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            if (r9 != 0) goto L_0x000e
            java.lang.String r9 = r1.toString()
            return r9
        L_0x000e:
            java.lang.String r2 = "gt_fp"
            java.lang.String r3 = com.geetest.captcha.f.a(r9, r2)
            java.lang.String r4 = "gt_ts"
            long r5 = com.geetest.captcha.f.b(r9, r4)
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            long r5 = java.lang.System.currentTimeMillis()
            r7 = 0
            android.content.SharedPreferences r2 = r9.getSharedPreferences(r2, r7)     // Catch:{ Exception -> 0x0034 }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0034 }
            android.content.SharedPreferences$Editor r2 = r2.putLong(r4, r5)     // Catch:{ Exception -> 0x0034 }
            r2.apply()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            java.lang.String r2 = com.geetest.captcha.m.a(r9)     // Catch:{ JSONException -> 0x00b0 }
            boolean r4 = com.geetest.captcha.f.a(r3)     // Catch:{ JSONException -> 0x00b0 }
            if (r4 == 0) goto L_0x0048
            boolean r4 = com.geetest.captcha.f.a(r2)     // Catch:{ JSONException -> 0x00b0 }
            if (r4 != 0) goto L_0x0048
            java.lang.String r3 = com.geetest.captcha.f.c(r9, r2)     // Catch:{ JSONException -> 0x00b0 }
        L_0x0048:
            java.lang.String r4 = "bd"
            r1.put(r4, r2)     // Catch:{ JSONException -> 0x00b0 }
            android.util.Pair r2 = com.geetest.captcha.i.a(r9)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r4 = "e"
            java.lang.String r7 = "d"
            if (r2 == 0) goto L_0x007a
            java.lang.Object r0 = r2.first     // Catch:{ JSONException -> 0x00b0 }
            r1.put(r7, r0)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.Object r0 = r2.second     // Catch:{ JSONException -> 0x00b0 }
            r1.put(r4, r0)     // Catch:{ JSONException -> 0x00b0 }
            boolean r0 = com.geetest.captcha.f.a(r3)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x0080
            java.lang.Object r0 = r2.first     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x00b0 }
            boolean r0 = com.geetest.captcha.f.a(r0)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 != 0) goto L_0x0080
            java.lang.Object r0 = r2.first     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r3 = com.geetest.captcha.f.c(r9, r0)     // Catch:{ JSONException -> 0x00b0 }
            goto L_0x0080
        L_0x007a:
            r1.put(r7, r0)     // Catch:{ JSONException -> 0x00b0 }
            r1.put(r4, r0)     // Catch:{ JSONException -> 0x00b0 }
        L_0x0080:
            boolean r0 = com.geetest.captcha.f.a(r3)     // Catch:{ JSONException -> 0x00b0 }
            if (r0 == 0) goto L_0x0092
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r3 = com.geetest.captcha.f.c(r9, r0)     // Catch:{ JSONException -> 0x00b0 }
        L_0x0092:
            java.lang.String r9 = "fp"
            r1.put(r9, r3)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r9 = "ts"
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x00b0 }
            r1.put(r9, r0)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r9 = "ver"
            java.lang.String r0 = "1.0.0"
            r1.put(r9, r0)     // Catch:{ JSONException -> 0x00b0 }
            java.lang.String r9 = "client_type"
            java.lang.String r0 = "android"
            r1.put(r9, r0)     // Catch:{ JSONException -> 0x00b0 }
        L_0x00b0:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.h.a(android.content.Context):java.lang.String");
    }

    private h() {
    }
}
