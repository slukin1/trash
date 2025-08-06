package com.mob.commons;

import android.os.Bundle;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.b.c;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.mob.commons.r  reason: case insensitive filesystem */
public class C0891r {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f27321a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f27322b = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f27323c = null;

    /* renamed from: d  reason: collision with root package name */
    public static volatile String f27324d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile InternationalDomain f27325e = null;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f27326f = false;

    /* renamed from: g  reason: collision with root package name */
    public static volatile boolean f27327g = false;

    /* renamed from: h  reason: collision with root package name */
    public static volatile boolean f27328h = true;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f27329i = false;

    /* renamed from: j  reason: collision with root package name */
    public static volatile String f27330j;

    /* renamed from: k  reason: collision with root package name */
    private static AtomicBoolean f27331k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private static final String f27332l = b("0090gbcjeedkekhbckce@h");

    /* renamed from: m  reason: collision with root package name */
    private static final String f27333m = b("011.dk6gcZciIe;dkekhbckceSh");

    /* renamed from: n  reason: collision with root package name */
    private static final String f27334n = b("0108gbcjeefkcfeh?gEckce3h");

    /* renamed from: o  reason: collision with root package name */
    private static final String f27335o = b("012ZdkHebDfj[eEcichdedbckce h");

    /* renamed from: p  reason: collision with root package name */
    private static final String f27336p = b("009Ddkgbdkdkekhbckce^h");

    /* renamed from: q  reason: collision with root package name */
    private static final String f27337q = b("010Vgbcjeeedch3dHdgckce(h");

    /* renamed from: r  reason: collision with root package name */
    private static HashMap<String, HashMap<String, Object>> f27338r = new HashMap<>();

    /* JADX WARNING: Can't wrap try/catch for region: R(2:34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        f27325e = com.mob.commons.InternationalDomain.DEFAULT;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00a9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r4) {
        /*
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.util.concurrent.atomic.AtomicBoolean r0 = f27331k     // Catch:{ all -> 0x010a }
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x0112
            r0 = 0
            java.lang.String r1 = f27321a     // Catch:{ all -> 0x0094 }
            if (r1 != 0) goto L_0x0050
            java.lang.String r1 = "010;gbcjeegjecSiiDhb0e?db"
            java.lang.String r1 = b(r1)     // Catch:{ all -> 0x0094 }
            java.lang.Object r1 = com.mob.commons.MobMeta.get(r0, r1, r4, r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 != 0) goto L_0x002f
            f27321a = r1     // Catch:{ all -> 0x0094 }
            f27323c = r1     // Catch:{ all -> 0x0094 }
            com.mob.commons.ab r2 = com.mob.commons.ab.a()     // Catch:{ all -> 0x0094 }
            r2.e((java.lang.String) r1)     // Catch:{ all -> 0x0094 }
            goto L_0x0050
        L_0x002f:
            com.mob.commons.ab r1 = com.mob.commons.ab.a()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.k()     // Catch:{ all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x0041
            java.lang.String r1 = com.mob.commons.x.i()     // Catch:{ all -> 0x0094 }
        L_0x0041:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 != 0) goto L_0x0050
            f27323c = r1     // Catch:{ all -> 0x0094 }
            com.mob.commons.ab r2 = com.mob.commons.ab.a()     // Catch:{ all -> 0x0094 }
            r2.e((java.lang.String) r1)     // Catch:{ all -> 0x0094 }
        L_0x0050:
            java.lang.String r1 = f27322b     // Catch:{ all -> 0x0094 }
            if (r1 != 0) goto L_0x0094
            java.lang.String r1 = "013Egbcjeegjec_ii0dk(eb=ciYeh"
            java.lang.String r1 = b(r1)     // Catch:{ all -> 0x0094 }
            java.lang.Object r1 = com.mob.commons.MobMeta.get(r0, r1, r4, r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 == 0) goto L_0x0072
            java.lang.String r1 = "012 gbcjeegjec_ii6dk@eAci!eh"
            java.lang.String r1 = b(r1)     // Catch:{ all -> 0x0094 }
            java.lang.Object r1 = com.mob.commons.MobMeta.get(r0, r1, r4, r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0094 }
        L_0x0072:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 != 0) goto L_0x0084
            f27322b = r1     // Catch:{ all -> 0x0094 }
            f27324d = r1     // Catch:{ all -> 0x0094 }
            com.mob.commons.ab r2 = com.mob.commons.ab.a()     // Catch:{ all -> 0x0094 }
            r2.f(r1)     // Catch:{ all -> 0x0094 }
            goto L_0x0094
        L_0x0084:
            com.mob.commons.ab r1 = com.mob.commons.ab.a()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r1.l()     // Catch:{ all -> 0x0094 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0094 }
            if (r2 != 0) goto L_0x0094
            f27324d = r1     // Catch:{ all -> 0x0094 }
        L_0x0094:
            java.lang.String r1 = "006)ekcjce!c<chCd"
            java.lang.String r1 = b(r1)     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = com.mob.commons.MobMeta.get(r0, r1, r4, r0)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x00ad
            com.mob.commons.InternationalDomain r1 = com.mob.commons.InternationalDomain.domainOf(r1)     // Catch:{ all -> 0x00a9 }
            f27325e = r1     // Catch:{ all -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            com.mob.commons.InternationalDomain r1 = com.mob.commons.InternationalDomain.DEFAULT     // Catch:{ all -> 0x010a }
            f27325e = r1     // Catch:{ all -> 0x010a }
        L_0x00ad:
            java.lang.String r1 = "015NgbcjeegjfgcbfjchcccjecHii4ddcb"
            java.lang.String r1 = b(r1)     // Catch:{ all -> 0x010a }
            java.lang.Object r4 = com.mob.commons.MobMeta.get(r0, r1, r4, r0)     // Catch:{ all -> 0x010a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x010a }
            f27330j = r4     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "0090gbcjeegjejUhhiNeh"
            java.lang.String r4 = b(r4)     // Catch:{ all -> 0x010a }
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x010a }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x010a }
            java.lang.Object r4 = com.mob.commons.MobMeta.get(r0, r4, r1, r2)     // Catch:{ all -> 0x010a }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x010a }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x010a }
            f27326f = r4     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "006Sgbcjeegjfjgg"
            java.lang.String r4 = b(r4)     // Catch:{ all -> 0x010a }
            java.lang.Object r4 = com.mob.commons.MobMeta.get(r0, r4, r1, r2)     // Catch:{ all -> 0x010a }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x010a }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x010a }
            f27327g = r4     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "008TgbcjeegjRef5cjdi"
            java.lang.String r4 = b(r4)     // Catch:{ all -> 0x010a }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x010a }
            java.lang.Object r4 = com.mob.commons.MobMeta.get(r0, r4, r1, r3)     // Catch:{ all -> 0x010a }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x010a }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x010a }
            f27328h = r4     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "007?gbcjeegjhcfkfk"
            java.lang.String r4 = b(r4)     // Catch:{ all -> 0x010a }
            java.lang.Object r4 = com.mob.commons.MobMeta.get(r0, r4, r1, r2)     // Catch:{ all -> 0x010a }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x010a }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x010a }
            f27329i = r4     // Catch:{ all -> 0x010a }
            goto L_0x0112
        L_0x010a:
            r4 = move-exception
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            r0.d(r4)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.C0891r.a(android.content.Context):void");
    }

    public static String b(String str) {
        return v.a(str, 98);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[ADDED_TO_REGION, Catch:{ all -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.String r9, java.lang.Class<T> r10, com.mob.commons.MobProduct r11) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.String r11 = a((com.mob.commons.MobProduct) r11)     // Catch:{ all -> 0x018d }
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r4 = f27338r     // Catch:{ all -> 0x018d }
            boolean r4 = r4.containsKey(r11)     // Catch:{ all -> 0x018d }
            if (r4 == 0) goto L_0x001b
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r4 = f27338r     // Catch:{ all -> 0x018d }
            java.lang.Object r11 = r4.get(r11)     // Catch:{ all -> 0x018d }
            java.util.HashMap r11 = (java.util.HashMap) r11     // Catch:{ all -> 0x018d }
            r4 = r3
            r5 = r4
            goto L_0x0060
        L_0x001b:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0052 }
            android.content.Context r5 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x0052 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ all -> 0x0052 }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ all -> 0x0052 }
            java.io.InputStream r5 = r5.open(r11)     // Catch:{ all -> 0x0052 }
            r4.<init>(r5)     // Catch:{ all -> 0x0052 }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ all -> 0x004f }
            r5.<init>(r4)     // Catch:{ all -> 0x004f }
            java.lang.Object r6 = r5.readObject()     // Catch:{ all -> 0x004d }
            java.util.HashMap r6 = (java.util.HashMap) r6     // Catch:{ all -> 0x004d }
            if (r6 == 0) goto L_0x004b
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0049 }
            if (r7 != 0) goto L_0x004b
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.Object>> r7 = f27338r     // Catch:{ all -> 0x0049 }
            r7.put(r11, r6)     // Catch:{ all -> 0x0049 }
            goto L_0x004b
        L_0x0049:
            r11 = r6
            goto L_0x0055
        L_0x004b:
            r11 = r6
            goto L_0x0060
        L_0x004d:
            r11 = r3
            goto L_0x0055
        L_0x004f:
            r11 = r3
            r5 = r11
            goto L_0x0055
        L_0x0052:
            r11 = r3
            r4 = r11
            r5 = r4
        L_0x0055:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0189 }
            java.lang.String r7 = "No ast file"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0189 }
            r6.d(r7, r8)     // Catch:{ all -> 0x0189 }
        L_0x0060:
            if (r11 == 0) goto L_0x017f
            boolean r6 = r11.isEmpty()     // Catch:{ all -> 0x0189 }
            if (r6 != 0) goto L_0x017f
            java.lang.Object r11 = r11.get(r9)     // Catch:{ all -> 0x0189 }
            java.lang.String r6 = "009Mgbcjeegjej0hhi%eh"
            java.lang.String r6 = b(r6)     // Catch:{ all -> 0x0189 }
            boolean r9 = r6.equals(r9)     // Catch:{ all -> 0x0189 }
            if (r9 == 0) goto L_0x00a8
            if (r11 == 0) goto L_0x00a8
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0189 }
            if (r9 == 0) goto L_0x00a8
            java.lang.String r9 = "003 db$eWeh"
            java.lang.String r9 = b(r9)     // Catch:{ all -> 0x0189 }
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0189 }
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ all -> 0x0189 }
            if (r9 != 0) goto L_0x00a1
            java.lang.String r9 = "004hBcicfCe"
            java.lang.String r9 = b(r9)     // Catch:{ all -> 0x0189 }
            java.lang.String r10 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0189 }
            boolean r9 = r9.equalsIgnoreCase(r10)     // Catch:{ all -> 0x0189 }
            if (r9 == 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r9 = r2
            goto L_0x00a2
        L_0x00a1:
            r9 = r1
        L_0x00a2:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0189 }
            goto L_0x017f
        L_0x00a8:
            if (r11 == 0) goto L_0x017f
            if (r10 == 0) goto L_0x017b
            java.lang.Class<java.lang.Void> r9 = java.lang.Void.class
            if (r10 != r9) goto L_0x00b2
            goto L_0x017f
        L_0x00b2:
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x00cb
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x00c2
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x00c2:
            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
        L_0x00c8:
            r3 = r9
            goto L_0x017f
        L_0x00cb:
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x00e2
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x00db
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x00db:
            java.lang.Class<java.lang.Integer> r9 = java.lang.Integer.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x00e2:
            java.lang.Class r9 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x00f9
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x00f2
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x00f2:
            java.lang.Class<java.lang.Byte> r9 = java.lang.Byte.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x00f9:
            java.lang.Class r9 = java.lang.Character.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x010d
            boolean r10 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r10 == 0) goto L_0x0106
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x0106:
            java.lang.Class<java.lang.Character> r9 = java.lang.Character.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x010d:
            java.lang.Class r9 = java.lang.Short.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x0124
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x011d
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Short r9 = java.lang.Short.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x011d:
            java.lang.Class<java.lang.Short> r9 = java.lang.Short.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x0124:
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x013b
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x0134
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x0134:
            java.lang.Class<java.lang.Long> r9 = java.lang.Long.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x013b:
            java.lang.Class r9 = java.lang.Float.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x0154
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x014c
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x014c:
            java.lang.Class<java.lang.Float> r9 = java.lang.Float.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x0154:
            java.lang.Class r9 = java.lang.Double.TYPE     // Catch:{ all -> 0x0173 }
            if (r10 != r9) goto L_0x016d
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0173 }
            if (r9 == 0) goto L_0x0165
            r9 = r11
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0173 }
            java.lang.Double r9 = java.lang.Double.valueOf(r9)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x0165:
            java.lang.Class<java.lang.Double> r9 = java.lang.Double.class
            java.lang.Object r9 = r9.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x016d:
            java.lang.Object r9 = r10.cast(r11)     // Catch:{ all -> 0x0173 }
            goto L_0x00c8
        L_0x0173:
            r9 = move-exception
            com.mob.tools.log.NLog r10 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x017d }
            r10.d(r9)     // Catch:{ all -> 0x017d }
        L_0x017b:
            r3 = r11
            goto L_0x017f
        L_0x017d:
            r9 = move-exception
            goto L_0x018b
        L_0x017f:
            java.io.Closeable[] r9 = new java.io.Closeable[r0]
            r9[r2] = r5
            r9[r1] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            goto L_0x01a1
        L_0x0189:
            r9 = move-exception
            r11 = r3
        L_0x018b:
            r3 = r5
            goto L_0x0190
        L_0x018d:
            r9 = move-exception
            r11 = r3
            r4 = r11
        L_0x0190:
            com.mob.tools.log.NLog r10 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x01a2 }
            r10.d(r9)     // Catch:{ all -> 0x01a2 }
            java.io.Closeable[] r9 = new java.io.Closeable[r0]
            r9[r2] = r3
            r9[r1] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r9)
            r3 = r11
        L_0x01a1:
            return r3
        L_0x01a2:
            r9 = move-exception
            java.io.Closeable[] r10 = new java.io.Closeable[r0]
            r10[r2] = r3
            r10[r1] = r4
            com.mob.commons.v.a((java.io.Closeable[]) r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.C0891r.a(java.lang.String, java.lang.Class, com.mob.commons.MobProduct):java.lang.Object");
    }

    public static <T> T a(String str) {
        try {
            Bundle bundle = c.a(MobSDK.getContext()).d().a(MobSDK.getContext().getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            T t11 = bundle.get(str);
            if (b("009Fgbcjeegjej2hhiGeh").equals(str) && t11 != null && (t11 instanceof String)) {
                return Boolean.valueOf(b("0035dbKe:eh").equalsIgnoreCase(String.valueOf(t11)));
            }
            if (t11 != null) {
                return t11;
            }
            return null;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private static String a(MobProduct mobProduct) {
        String str;
        String str2 = f27332l;
        if (mobProduct == null) {
            return str2;
        }
        try {
            String productTag = mobProduct.getProductTag();
            if (b("008^dkejecfifhdkekhb").equals(productTag)) {
                str = f27333m;
            } else if (b("006Bdkgbdkdkekhb").equals(productTag)) {
                str = f27336p;
            } else if (b("007Kgbfgeieddddfhb").equals(productTag)) {
                str = f27337q;
            } else if (b("0072gbfgeifkdjdkej").equals(productTag)) {
                str = f27334n;
            } else if (!b("009[dkfhdcfjfhfiddfbhk").equals(productTag)) {
                return str2;
            } else {
                str = f27335o;
            }
            return str;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return str2;
        }
    }
}
