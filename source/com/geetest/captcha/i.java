package com.geetest.captcha;

import android.annotation.SuppressLint;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

final class i {
    @SuppressLint({"SdCardPath"})

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f65231a = {"/sdcard/.system_log.trace", "/sdcard/tencent/.DrvZPZQ", "/sdcard/alipay/.Wg83DS3"};

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r12 = f65231a;
        r11 = com.geetest.captcha.l.a(new java.io.FileReader(r12[2]));
        r14 = new org.json.JSONObject(new java.lang.String(com.geetest.captcha.e.a(android.util.Base64.decode(r11, 2), "VedaT=ZbPq0Zv7Do")));
        com.geetest.captcha.f.a(r0, "gt_di", r11);
        a(r11, r12[0]);
        a(r11, r12[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cc, code lost:
        return new android.util.Pair<>(r14.getString("gee_id"), r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r11 = java.util.UUID.randomUUID().toString();
        r12 = new org.json.JSONObject();
        r12.put("gee_id", r11);
        r12.put(com.twitter.sdk.android.core.identity.AuthHandler.EXTRA_TOKEN_SECRET, java.lang.System.currentTimeMillis());
        r12.put("ver", com.huochat.community.base.CommunityConstants.COMMUNITY_SDK_VERSION);
        r7 = r12.toString();
        r12 = new java.lang.String(com.geetest.captcha.e.a());
        r7 = r7.getBytes("utf-8");
        r9 = "VedaT=ZbPq0Zv7Do".getBytes("utf-8");
        r12 = r12.getBytes("utf-8");
        r12 = java.lang.Class.forName(com.geetest.captcha.e.a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new java.lang.Class[]{r2}).newInstance(new java.lang.Object[]{r12});
        r9 = java.lang.Class.forName(com.geetest.captcha.e.a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new java.lang.Class[]{r2, r1}).newInstance(new java.lang.Object[]{r9, com.sumsub.sns.prooface.network.b.f40261d});
        r13 = java.lang.Class.forName(com.geetest.captcha.e.a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        r1 = r13.getMethod("getInstance", new java.lang.Class[]{r1}).invoke(r13, new java.lang.Object[]{com.sumsub.sns.internal.core.common.k.f32093a});
        r13.getMethod(zendesk.core.ZendeskBlipsProvider.ACTION_CORE_INIT, new java.lang.Class[]{java.lang.Integer.TYPE, java.security.Key.class, java.security.spec.AlgorithmParameterSpec.class}).invoke(r1, new java.lang.Object[]{1, r9, r12});
        r1 = com.geetest.captcha.l.a(android.util.Base64.encode((byte[]) r13.getMethod("doFinal", new java.lang.Class[]{r2}).invoke(r1, new java.lang.Object[]{r7}), 2), "utf-8");
        com.geetest.captcha.f.a(r0, "gt_di", r1);
        r0 = f65231a;
        a(r1, r0[0]);
        a(r1, r0[1]);
        a(r1, r0[2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x01b9, code lost:
        return new android.util.Pair<>(r11, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x01ba, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0097 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00cd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.String, java.lang.String> a(android.content.Context r17) {
        /*
            r0 = r17
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.Class<byte[]> r2 = byte[].class
            java.lang.String r3 = "gt_di"
            java.lang.String r4 = com.geetest.captcha.f.a(r0, r3)
            boolean r5 = com.geetest.captcha.f.a(r4)
            r6 = 0
            java.lang.String r7 = "gee_id"
            java.lang.String r8 = "utf-8"
            java.lang.String r9 = "VedaT=ZbPq0Zv7Do"
            r10 = 2
            if (r5 == 0) goto L_0x01be
            int r4 = android.os.Process.myPid()
            int r5 = android.os.Process.myUid()
            java.lang.String r11 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r4 = r0.checkPermission(r11, r4, r5)
            if (r4 != 0) goto L_0x01bc
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r4 < r5) goto L_0x0038
            boolean r4 = android.os.Environment.isExternalStorageLegacy()
            if (r4 != 0) goto L_0x0038
            return r6
        L_0x0038:
            r4 = 0
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x0065 }
            java.lang.String[] r11 = f65231a     // Catch:{ Exception -> 0x0065 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0065 }
            r5.<init>(r11)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r5 = com.geetest.captcha.l.a(r5)     // Catch:{ Exception -> 0x0065 }
            byte[] r11 = android.util.Base64.decode(r5, r10)     // Catch:{ Exception -> 0x0065 }
            byte[] r11 = com.geetest.captcha.e.a(r11, r9)     // Catch:{ Exception -> 0x0065 }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0065 }
            java.lang.String r13 = new java.lang.String     // Catch:{ Exception -> 0x0065 }
            r13.<init>(r11)     // Catch:{ Exception -> 0x0065 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x0065 }
            com.geetest.captcha.f.a(r0, r3, r5)     // Catch:{ Exception -> 0x0065 }
            android.util.Pair r11 = new android.util.Pair     // Catch:{ Exception -> 0x0065 }
            java.lang.String r12 = r12.getString(r7)     // Catch:{ Exception -> 0x0065 }
            r11.<init>(r12, r5)     // Catch:{ Exception -> 0x0065 }
            return r11
        L_0x0065:
            r5 = 1
            java.io.FileReader r11 = new java.io.FileReader     // Catch:{ Exception -> 0x0097 }
            java.lang.String[] r12 = f65231a     // Catch:{ Exception -> 0x0097 }
            r13 = r12[r5]     // Catch:{ Exception -> 0x0097 }
            r11.<init>(r13)     // Catch:{ Exception -> 0x0097 }
            java.lang.String r11 = com.geetest.captcha.l.a(r11)     // Catch:{ Exception -> 0x0097 }
            byte[] r13 = android.util.Base64.decode(r11, r10)     // Catch:{ Exception -> 0x0097 }
            byte[] r13 = com.geetest.captcha.e.a(r13, r9)     // Catch:{ Exception -> 0x0097 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0097 }
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x0097 }
            r15.<init>(r13)     // Catch:{ Exception -> 0x0097 }
            r14.<init>(r15)     // Catch:{ Exception -> 0x0097 }
            com.geetest.captcha.f.a(r0, r3, r11)     // Catch:{ Exception -> 0x0097 }
            r12 = r12[r4]     // Catch:{ Exception -> 0x0097 }
            a(r11, r12)     // Catch:{ Exception -> 0x0097 }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x0097 }
            java.lang.String r13 = r14.getString(r7)     // Catch:{ Exception -> 0x0097 }
            r12.<init>(r13, r11)     // Catch:{ Exception -> 0x0097 }
            return r12
        L_0x0097:
            java.io.FileReader r11 = new java.io.FileReader     // Catch:{ Exception -> 0x00cd }
            java.lang.String[] r12 = f65231a     // Catch:{ Exception -> 0x00cd }
            r13 = r12[r10]     // Catch:{ Exception -> 0x00cd }
            r11.<init>(r13)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r11 = com.geetest.captcha.l.a(r11)     // Catch:{ Exception -> 0x00cd }
            byte[] r13 = android.util.Base64.decode(r11, r10)     // Catch:{ Exception -> 0x00cd }
            byte[] r13 = com.geetest.captcha.e.a(r13, r9)     // Catch:{ Exception -> 0x00cd }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x00cd }
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x00cd }
            r15.<init>(r13)     // Catch:{ Exception -> 0x00cd }
            r14.<init>(r15)     // Catch:{ Exception -> 0x00cd }
            com.geetest.captcha.f.a(r0, r3, r11)     // Catch:{ Exception -> 0x00cd }
            r13 = r12[r4]     // Catch:{ Exception -> 0x00cd }
            a(r11, r13)     // Catch:{ Exception -> 0x00cd }
            r12 = r12[r5]     // Catch:{ Exception -> 0x00cd }
            a(r11, r12)     // Catch:{ Exception -> 0x00cd }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x00cd }
            java.lang.String r13 = r14.getString(r7)     // Catch:{ Exception -> 0x00cd }
            r12.<init>(r13, r11)     // Catch:{ Exception -> 0x00cd }
            return r12
        L_0x00cd:
            java.util.UUID r11 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x01ba }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01ba }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x01ba }
            r12.<init>()     // Catch:{ Exception -> 0x01ba }
            r12.put(r7, r11)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r7 = "ts"
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01ba }
            r12.put(r7, r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r7 = "ver"
            java.lang.String r13 = "1.0.0"
            r12.put(r7, r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r7 = r12.toString()     // Catch:{ Exception -> 0x01ba }
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x01ba }
            byte[] r13 = com.geetest.captcha.e.a()     // Catch:{ Exception -> 0x01ba }
            r12.<init>(r13)     // Catch:{ Exception -> 0x01ba }
            byte[] r7 = r7.getBytes(r8)     // Catch:{ Exception -> 0x01ba }
            byte[] r9 = r9.getBytes(r8)     // Catch:{ Exception -> 0x01ba }
            byte[] r12 = r12.getBytes(r8)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r13 = "amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj"
            java.lang.String r13 = com.geetest.captcha.e.a(r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.Class[] r14 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x01ba }
            r14[r4] = r2     // Catch:{ Exception -> 0x01ba }
            java.lang.reflect.Constructor r13 = r13.getConstructor(r14)     // Catch:{ Exception -> 0x01ba }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01ba }
            r14[r4] = r12     // Catch:{ Exception -> 0x01ba }
            java.lang.Object r12 = r13.newInstance(r14)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r13 = "amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw=="
            java.lang.String r13 = com.geetest.captcha.e.a(r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x01ba }
            r14[r4] = r2     // Catch:{ Exception -> 0x01ba }
            r14[r5] = r1     // Catch:{ Exception -> 0x01ba }
            java.lang.reflect.Constructor r13 = r13.getConstructor(r14)     // Catch:{ Exception -> 0x01ba }
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x01ba }
            r14[r4] = r9     // Catch:{ Exception -> 0x01ba }
            java.lang.String r9 = "AES"
            r14[r5] = r9     // Catch:{ Exception -> 0x01ba }
            java.lang.Object r9 = r13.newInstance(r14)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r13 = "amF2YXguY3J5cHRvLkNpcGhlcg=="
            java.lang.String r13 = com.geetest.captcha.e.a(r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.Class r13 = java.lang.Class.forName(r13)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r14 = "getInstance"
            java.lang.Class[] r15 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x01ba }
            r15[r4] = r1     // Catch:{ Exception -> 0x01ba }
            java.lang.reflect.Method r1 = r13.getMethod(r14, r15)     // Catch:{ Exception -> 0x01ba }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01ba }
            java.lang.String r15 = "AES/CBC/PKCS5Padding"
            r14[r4] = r15     // Catch:{ Exception -> 0x01ba }
            java.lang.Object r1 = r1.invoke(r13, r14)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r14 = "init"
            r15 = 3
            java.lang.Class[] r6 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x01ba }
            java.lang.Class r16 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x01ba }
            r6[r4] = r16     // Catch:{ Exception -> 0x01ba }
            java.lang.Class<java.security.Key> r16 = java.security.Key.class
            r6[r5] = r16     // Catch:{ Exception -> 0x01ba }
            java.lang.Class<java.security.spec.AlgorithmParameterSpec> r16 = java.security.spec.AlgorithmParameterSpec.class
            r6[r10] = r16     // Catch:{ Exception -> 0x01ba }
            java.lang.reflect.Method r6 = r13.getMethod(r14, r6)     // Catch:{ Exception -> 0x01ba }
            java.lang.Object[] r14 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01ba }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01ba }
            r14[r4] = r15     // Catch:{ Exception -> 0x01ba }
            r14[r5] = r9     // Catch:{ Exception -> 0x01ba }
            r14[r10] = r12     // Catch:{ Exception -> 0x01ba }
            r6.invoke(r1, r14)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r6 = "doFinal"
            java.lang.Class[] r9 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x01ba }
            r9[r4] = r2     // Catch:{ Exception -> 0x01ba }
            java.lang.reflect.Method r2 = r13.getMethod(r6, r9)     // Catch:{ Exception -> 0x01ba }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01ba }
            r6[r4] = r7     // Catch:{ Exception -> 0x01ba }
            java.lang.Object r1 = r2.invoke(r1, r6)     // Catch:{ Exception -> 0x01ba }
            byte[] r1 = (byte[]) r1     // Catch:{ Exception -> 0x01ba }
            byte[] r1 = android.util.Base64.encode(r1, r10)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r1 = com.geetest.captcha.l.a((byte[]) r1, (java.lang.String) r8)     // Catch:{ Exception -> 0x01ba }
            com.geetest.captcha.f.a(r0, r3, r1)     // Catch:{ Exception -> 0x01ba }
            java.lang.String[] r0 = f65231a     // Catch:{ Exception -> 0x01ba }
            r2 = r0[r4]     // Catch:{ Exception -> 0x01ba }
            a(r1, r2)     // Catch:{ Exception -> 0x01ba }
            r2 = r0[r5]     // Catch:{ Exception -> 0x01ba }
            a(r1, r2)     // Catch:{ Exception -> 0x01ba }
            r0 = r0[r10]     // Catch:{ Exception -> 0x01ba }
            a(r1, r0)     // Catch:{ Exception -> 0x01ba }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ Exception -> 0x01ba }
            r0.<init>(r11, r1)     // Catch:{ Exception -> 0x01ba }
            return r0
        L_0x01ba:
            r0 = 0
            goto L_0x01bd
        L_0x01bc:
            r0 = r6
        L_0x01bd:
            return r0
        L_0x01be:
            byte[] r0 = android.util.Base64.decode(r4, r10)     // Catch:{ Exception -> 0x01d9 }
            byte[] r0 = com.geetest.captcha.e.a(r0, r9)     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r0 = com.geetest.captcha.l.a((byte[]) r0, (java.lang.String) r8)     // Catch:{ Exception -> 0x01d9 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x01d9 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01d9 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ Exception -> 0x01d9 }
            java.lang.String r1 = r1.getString(r7)     // Catch:{ Exception -> 0x01d9 }
            r0.<init>(r1, r4)     // Catch:{ Exception -> 0x01d9 }
            return r0
        L_0x01d9:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.i.a(android.content.Context):android.util.Pair");
    }

    private static void a(String str, String str2) {
        try {
            FileWriter fileWriter = new FileWriter(str2);
            l.a(str, (Writer) fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }
}
