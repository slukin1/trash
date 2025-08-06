package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hbg.lib.network.pro.core.util.Period;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.q;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.Random;

public class bi implements Runnable {
    private bi() {
    }

    public static void a(Context context) {
        if (context != null && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            a aVar = new a(context);
            if (aVar.a()) {
                new Thread(new bi()).start();
                aVar.a();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.xiaomi.push.be} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.xiaomi.push.be} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: com.xiaomi.push.be} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: com.xiaomi.push.be} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a1 A[Catch:{ Exception -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c5 A[Catch:{ Exception -> 0x01eb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "mipush|"
            java.lang.String r2 = "mipush_"
            java.lang.String r3 = "s"
            java.lang.String r4 = "com.xiaomi.xmsf"
            java.lang.String r5 = "c"
            android.content.Context r6 = com.xiaomi.push.s.a()
            if (r6 == 0) goto L_0x01f6
            com.xiaomi.push.be r7 = new com.xiaomi.push.be
            r7.<init>()
            com.xiaomi.push.bd r8 = new com.xiaomi.push.bd
            r9 = 50
            r11 = 1000(0x3e8, double:4.94E-321)
            r8.<init>(r9, r11)
            android.content.Context r10 = com.xiaomi.push.s.a()     // Catch:{ Exception -> 0x01f0 }
            java.lang.String r11 = "pref_registered_pkg_names"
            r12 = 0
            android.content.SharedPreferences r10 = r10.getSharedPreferences(r11, r12)     // Catch:{ Exception -> 0x01f0 }
            java.util.Map r10 = r10.getAll()     // Catch:{ Exception -> 0x01f0 }
            if (r10 == 0) goto L_0x01ed
            boolean r11 = r10.isEmpty()     // Catch:{ Exception -> 0x01f0 }
            if (r11 != 0) goto L_0x01ed
            java.util.Set r11 = r10.keySet()     // Catch:{ Exception -> 0x01f0 }
            boolean r12 = r11.contains(r4)     // Catch:{ Exception -> 0x01f0 }
            r13 = 1
            if (r12 == 0) goto L_0x004e
            int r11 = r11.size()     // Catch:{ Exception -> 0x0049 }
            int r11 = r11 - r13
        L_0x0047:
            long r11 = (long) r11
            goto L_0x0053
        L_0x0049:
            r0 = move-exception
            r9 = r0
            r2 = r7
            goto L_0x01f3
        L_0x004e:
            int r11 = r11.size()     // Catch:{ Exception -> 0x01f0 }
            goto L_0x0047
        L_0x0053:
            r7.a(r11)     // Catch:{ Exception -> 0x01f0 }
            com.xiaomi.push.bh r11 = new com.xiaomi.push.bh     // Catch:{ Exception -> 0x01f0 }
            r11.<init>()     // Catch:{ Exception -> 0x01f0 }
            long r14 = r7.a()     // Catch:{ Exception -> 0x01f0 }
            r11.put((java.lang.String) r5, (long) r14)     // Catch:{ Exception -> 0x01f0 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x01f0 }
            com.xiaomi.push.bg r12 = new com.xiaomi.push.bg     // Catch:{ Exception -> 0x01f0 }
            r12.<init>()     // Catch:{ Exception -> 0x01f0 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01f0 }
        L_0x006f:
            boolean r14 = r10.hasNext()     // Catch:{ Exception -> 0x01f0 }
            if (r14 == 0) goto L_0x01d5
            java.lang.Object r14 = r10.next()     // Catch:{ Exception -> 0x01f0 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ Exception -> 0x01f0 }
            java.lang.Object r15 = r14.getKey()     // Catch:{ Exception -> 0x01f0 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x01f0 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ Exception -> 0x01f0 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x01f0 }
            boolean r16 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x01f0 }
            if (r16 != 0) goto L_0x0191
            boolean r16 = r4.equals(r15)     // Catch:{ Exception -> 0x0049 }
            if (r16 != 0) goto L_0x0191
            boolean r16 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0049 }
            if (r16 != 0) goto L_0x0191
            com.xiaomi.push.bh r9 = new com.xiaomi.push.bh     // Catch:{ Exception -> 0x0049 }
            r9.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r13 = "a"
            r9.put((java.lang.String) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x0049 }
            com.xiaomi.push.bi$1 r13 = new com.xiaomi.push.bi$1     // Catch:{ Exception -> 0x0049 }
            r13.<init>(r6, r15)     // Catch:{ Exception -> 0x0049 }
            java.lang.Object r13 = r8.a(r13)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x0049 }
            r9.put((java.lang.String) r3, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0049 }
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0049 }
            r14 = 26
            if (r13 < r14) goto L_0x0176
            com.xiaomi.push.service.af r13 = com.xiaomi.push.service.af.a((android.content.Context) r6, (java.lang.String) r15)     // Catch:{ Exception -> 0x0049 }
            java.util.List r13 = r13.a()     // Catch:{ Exception -> 0x0049 }
            if (r13 == 0) goto L_0x0176
            boolean r14 = r13.isEmpty()     // Catch:{ Exception -> 0x0049 }
            if (r14 != 0) goto L_0x0176
            com.xiaomi.push.bg r14 = new com.xiaomi.push.bg     // Catch:{ Exception -> 0x0049 }
            r14.<init>()     // Catch:{ Exception -> 0x0049 }
            r17 = r4
            int r4 = r13.size()     // Catch:{ Exception -> 0x0049 }
            r18 = r10
            r19 = r11
            long r10 = (long) r4     // Catch:{ Exception -> 0x0049 }
            r7.b(r10)     // Catch:{ Exception -> 0x0049 }
            java.util.Iterator r4 = r13.iterator()     // Catch:{ Exception -> 0x0049 }
        L_0x00de:
            boolean r10 = r4.hasNext()     // Catch:{ Exception -> 0x0049 }
            if (r10 == 0) goto L_0x016a
            java.lang.Object r10 = r4.next()     // Catch:{ Exception -> 0x0049 }
            android.app.NotificationChannel r10 = (android.app.NotificationChannel) r10     // Catch:{ Exception -> 0x0049 }
            java.lang.String r11 = r10.getId()     // Catch:{ Exception -> 0x0049 }
            com.xiaomi.push.bh r13 = new com.xiaomi.push.bh     // Catch:{ Exception -> 0x0049 }
            r13.<init>()     // Catch:{ Exception -> 0x0049 }
            boolean r20 = r11.startsWith(r2)     // Catch:{ Exception -> 0x0049 }
            r21 = r4
            java.lang.String r4 = "t"
            r22 = r7
            java.lang.String r7 = ""
            if (r20 == 0) goto L_0x0125
            r20 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r12.<init>()     // Catch:{ Exception -> 0x018b }
            r12.append(r2)     // Catch:{ Exception -> 0x018b }
            r12.append(r15)     // Catch:{ Exception -> 0x018b }
            r23 = r2
            java.lang.String r2 = "_"
            r12.append(r2)     // Catch:{ Exception -> 0x018b }
            java.lang.String r2 = r12.toString()     // Catch:{ Exception -> 0x018b }
            java.lang.String r2 = r11.replace(r2, r7)     // Catch:{ Exception -> 0x018b }
            r12 = 1
            r13.put((java.lang.String) r4, (int) r12)     // Catch:{ Exception -> 0x018b }
            r13.put((java.lang.String) r5, (java.lang.Object) r2)     // Catch:{ Exception -> 0x018b }
            goto L_0x014f
        L_0x0125:
            r23 = r2
            r20 = r12
            r12 = 1
            boolean r2 = r11.startsWith(r0)     // Catch:{ Exception -> 0x018b }
            if (r2 == 0) goto L_0x014f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018b }
            r2.<init>()     // Catch:{ Exception -> 0x018b }
            r2.append(r0)     // Catch:{ Exception -> 0x018b }
            r2.append(r15)     // Catch:{ Exception -> 0x018b }
            java.lang.String r12 = "|"
            r2.append(r12)     // Catch:{ Exception -> 0x018b }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x018b }
            java.lang.String r2 = r11.replace(r2, r7)     // Catch:{ Exception -> 0x018b }
            r7 = 2
            r13.put((java.lang.String) r4, (int) r7)     // Catch:{ Exception -> 0x018b }
            r13.put((java.lang.String) r5, (java.lang.Object) r2)     // Catch:{ Exception -> 0x018b }
        L_0x014f:
            com.xiaomi.push.bi$2 r2 = new com.xiaomi.push.bi$2     // Catch:{ Exception -> 0x018b }
            r2.<init>(r6, r15, r10)     // Catch:{ Exception -> 0x018b }
            java.lang.Object r2 = r8.a(r2)     // Catch:{ Exception -> 0x018b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x018b }
            r13.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ Exception -> 0x018b }
            r14.put(r13)     // Catch:{ Exception -> 0x018b }
            r12 = r20
            r4 = r21
            r7 = r22
            r2 = r23
            goto L_0x00de
        L_0x016a:
            r23 = r2
            r22 = r7
            r20 = r12
            r9.put((java.lang.String) r5, (java.lang.Object) r14)     // Catch:{ Exception -> 0x018b }
            r12 = r20
            goto L_0x0180
        L_0x0176:
            r23 = r2
            r17 = r4
            r22 = r7
            r18 = r10
            r19 = r11
        L_0x0180:
            r12.put(r9)     // Catch:{ Exception -> 0x018b }
            java.lang.String r2 = "d"
            r11 = r19
            r11.put((java.lang.String) r2, (java.lang.Object) r12)     // Catch:{ Exception -> 0x018b }
            goto L_0x0199
        L_0x018b:
            r0 = move-exception
            r9 = r0
            r2 = r22
            goto L_0x01f3
        L_0x0191:
            r23 = r2
            r17 = r4
            r22 = r7
            r18 = r10
        L_0x0199:
            int r2 = r11.a()     // Catch:{ Exception -> 0x01d1 }
            r4 = 30720(0x7800, float:4.3048E-41)
            if (r2 <= r4) goto L_0x01c5
            r22.a()     // Catch:{ Exception -> 0x01d1 }
            int r2 = r11.a()     // Catch:{ Exception -> 0x01d1 }
            long r9 = (long) r2
            r2 = r22
            r2.c(r9)     // Catch:{ Exception -> 0x01eb }
            r1.a((android.content.Context) r6, (com.xiaomi.push.bh) r11, (com.xiaomi.push.be) r2)     // Catch:{ Exception -> 0x01eb }
            com.xiaomi.push.bh r4 = new com.xiaomi.push.bh     // Catch:{ Exception -> 0x01eb }
            r4.<init>()     // Catch:{ Exception -> 0x01eb }
            long r9 = r2.a()     // Catch:{ Exception -> 0x01eb }
            r4.put((java.lang.String) r5, (long) r9)     // Catch:{ Exception -> 0x01eb }
            com.xiaomi.push.bg r7 = new com.xiaomi.push.bg     // Catch:{ Exception -> 0x01eb }
            r7.<init>()     // Catch:{ Exception -> 0x01eb }
            r11 = r4
            r12 = r7
            goto L_0x01c7
        L_0x01c5:
            r2 = r22
        L_0x01c7:
            r7 = r2
            r4 = r17
            r10 = r18
            r2 = r23
            r13 = 1
            goto L_0x006f
        L_0x01d1:
            r0 = move-exception
            r2 = r22
            goto L_0x01f2
        L_0x01d5:
            r2 = r7
            int r0 = r12.length()     // Catch:{ Exception -> 0x01eb }
            if (r0 <= 0) goto L_0x01ee
            r2.a()     // Catch:{ Exception -> 0x01eb }
            int r0 = r11.a()     // Catch:{ Exception -> 0x01eb }
            long r3 = (long) r0     // Catch:{ Exception -> 0x01eb }
            r2.c(r3)     // Catch:{ Exception -> 0x01eb }
            r1.a((android.content.Context) r6, (com.xiaomi.push.bh) r11, (com.xiaomi.push.be) r2)     // Catch:{ Exception -> 0x01eb }
            goto L_0x01ee
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f2
        L_0x01ed:
            r2 = r7
        L_0x01ee:
            r9 = 0
            goto L_0x01f3
        L_0x01f0:
            r0 = move-exception
            r2 = r7
        L_0x01f2:
            r9 = r0
        L_0x01f3:
            r1.a((com.xiaomi.push.be) r2, (com.xiaomi.push.bd) r8, (java.lang.Exception) r9)
        L_0x01f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bi.run():void");
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public SharedPreferences f51443a;

        /* renamed from: a  reason: collision with other field name */
        private final String f2559a = "dc_job_result_time_26";

        public a(Context context) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            this.f51443a = sharedPreferences;
            long j11 = sharedPreferences.getLong("dc_job_result_time_26", 0);
            if (j11 <= 0 || j11 - System.currentTimeMillis() > 259200000) {
                this.f51443a.edit().putLong("dc_job_result_time_26", a()).apply();
            }
        }

        private long a() {
            long currentTimeMillis = System.currentTimeMillis();
            Random random = new Random(currentTimeMillis);
            return (((currentTimeMillis / Period.DAY_MILLS) + 1) * Period.DAY_MILLS) + ((long) (random.nextInt(3) * 86400000)) + ((long) random.nextInt(46800000));
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2438a() {
            return System.currentTimeMillis() - this.f51443a.getLong("dc_job_result_time_26", 0) > 0;
        }

        private a() {
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m2437a() {
            long j11 = this.f51443a.getLong("dc_job_result_time_26", 0);
            long currentTimeMillis = System.currentTimeMillis() - j11;
            if (currentTimeMillis >= 0) {
                this.f51443a.edit().putLong("dc_job_result_time_26", j11 + (((currentTimeMillis / 259200000) + 1) * 259200000)).apply();
            }
        }
    }

    private void a(be beVar, bd bdVar, Exception exc) {
        HashMap hashMap = new HashMap();
        String a11 = q.a(s.a());
        if (!TextUtils.isEmpty(a11)) {
            hashMap.put(ZendeskIdentityStorage.UUID_KEY, a11);
        }
        hashMap.put("appCount", Long.valueOf(beVar.a()));
        hashMap.put("channels", Long.valueOf(beVar.b()));
        hashMap.put("packCount", Long.valueOf(beVar.c()));
        hashMap.put("totalSize", Long.valueOf(beVar.d()));
        hashMap.put("isBatch", Integer.valueOf(beVar.a()));
        hashMap.put("maxCallTime", Long.valueOf(bdVar.a()));
        hashMap.put("minCallTime", Long.valueOf(bdVar.b()));
        hashMap.put("callAvg", Long.valueOf(bdVar.c()));
        hashMap.put(IBridgeMediaLoader.COLUMN_DURATION, Long.valueOf(bdVar.d()));
        if (exc != null) {
            hashMap.put(Constants.EXCEPTION, exc.toString());
        }
        ei.a().a("app_switch_upload", hashMap);
    }

    private void a(Context context, bh bhVar, be beVar) {
        gk gkVar = new gk();
        gkVar.d("category_app_channel_info");
        gkVar.c("app_channel_info");
        gkVar.b(bhVar.toString());
        gkVar.a(false);
        gkVar.a(1);
        gkVar.a("xmsf_channel");
        gkVar.b(System.currentTimeMillis());
        gkVar.g("com.xiaomi.xmsf");
        gkVar.e("com.xiaomi.xmsf");
        gkVar.f(az.a());
        ba.a(context, gkVar);
    }
}
