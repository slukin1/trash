package com.qihoo.stat;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.sumsub.sns.internal.core.analytics.d;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static String f28707a = "QData";

    /* renamed from: b  reason: collision with root package name */
    public static String f28708b = "";

    public static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("qihoo_game_session_info", 0);
        sharedPreferences.edit().putLong("totalSession", sharedPreferences.getLong("totalSession", 0) + 1).commit();
    }

    public static void b(Context context, String str, long j11) {
        context.getSharedPreferences("qihoo_game_session_info", 0).edit().putLong(str, j11).commit();
    }

    public static void c(Context context, String str, String str2) {
        context.getSharedPreferences("qihoo_game_session_info", 0).edit().putString(str, str2).commit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01fc A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x020f A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0234 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0242 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0249 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0258 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x027c A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x031a A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0346 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x034c A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03e6 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0412 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0418 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04ac A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04d2 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x04d8 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0557 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0560 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0588 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x058f A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0614 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0633 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x0640 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0656 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013b A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0148 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0151 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0177 A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x017d A[Catch:{ Exception -> 0x067d, Error -> 0x0675, all -> 0x0672 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void d(android.content.Context r17, boolean r18) {
        /*
            java.lang.Class<com.qihoo.stat.c0> r1 = com.qihoo.stat.c0.class
            monitor-enter(r1)
            if (r18 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.b.f28703b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.d0.f28722b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.h0.f28770b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.s.f28841b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.a0.f28701b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.t.f28843b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            boolean r2 = com.qihoo.stat.c.f28706c     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r2 != 0) goto L_0x0023
            monitor-exit(r1)
            return
        L_0x0023:
            com.qihoo.stat.n r2 = com.qihoo.stat.d.f28714f     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r3 = com.qihoo.stat.u.S(r17)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r3 = com.qihoo.stat.u.k(r3)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r3 = com.qihoo.stat.u.q(r3)     // Catch:{ Exception -> 0x0046, Error -> 0x0032 }
            goto L_0x0057
        L_0x0032:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = f28707a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g0.a(r5, r4)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r5 = com.qihoo.stat.u.S(r17)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0042:
            r4.delete()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0057
        L_0x0046:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = f28707a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g0.b(r5, r4)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r5 = com.qihoo.stat.u.S(r17)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0042
        L_0x0057:
            com.qihoo.stat.j r4 = new com.qihoo.stat.j     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r4.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r4.b(r3)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r3.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r5.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r6 = r4.f28780a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r9 = 1
            if (r6 == 0) goto L_0x0139
            r6 = 0
        L_0x006f:
            java.util.Vector r10 = r4.f28780a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 < r10) goto L_0x0079
            goto L_0x0139
        L_0x0079:
            java.util.Vector r10 = r4.f28780a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.get(r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.n r10 = (com.qihoo.stat.n) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = r10.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r12 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 == 0) goto L_0x012e
            if (r18 == 0) goto L_0x012e
            long r11 = r2.f28819e     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r13 = r10.f28819e     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r11 = r11 + r13
            r2.f28819e = r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r11 = r2.f28820f     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r13 = r10.f28820f     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r11 = r11 + r13
            r2.f28820f = r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r10 = r10.f28818d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 == 0) goto L_0x0135
            int r11 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 <= 0) goto L_0x0135
            java.util.Vector r11 = r2.f28818d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 != 0) goto L_0x00b0
            java.util.Vector r11 = new java.util.Vector     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r11.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r2.f28818d = r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x00b0:
            r11 = 0
            r12 = 0
        L_0x00b2:
            int r13 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 < r13) goto L_0x00ba
            goto L_0x0135
        L_0x00ba:
            r13 = 0
        L_0x00bb:
            java.util.Vector r14 = r2.f28818d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r14 = r14.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r13 < r14) goto L_0x00c5
            r13 = 0
            goto L_0x00de
        L_0x00c5:
            java.util.Vector r12 = r2.f28818d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r12 = r12.get(r13)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g r12 = (com.qihoo.stat.g) r12     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r14 = r12.f28756a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r15 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g r15 = (com.qihoo.stat.g) r15     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r15 = r15.f28756a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r14 == 0) goto L_0x012b
            r13 = r9
        L_0x00de:
            if (r13 == 0) goto L_0x011d
            java.lang.String r13 = f28707a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r15 = "activity: "
            r14.<init>(r15)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r15 = r12.f28756a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r14.append(r15)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r15 = ",lastDuration: "
            r14.append(r15)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r15 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g r15 = (com.qihoo.stat.g) r15     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r7 = r15.f28759d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r14.append(r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r7 = ",currentDuration: "
            r14.append(r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r7 = r12.f28759d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r14.append(r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r7 = r14.toString()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g0.c(r13, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r7 = r12.f28759d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r13 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g r13 = (com.qihoo.stat.g) r13     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r13 = r13.f28759d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            long r7 = r7 + r13
            r12.f28759d = r7     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0128
        L_0x011d:
            java.util.Vector r7 = r2.f28818d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r8 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g r8 = (com.qihoo.stat.g) r8     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.add(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0128:
            int r11 = r11 + 1
            goto L_0x00b2
        L_0x012b:
            int r13 = r13 + 1
            goto L_0x00bb
        L_0x012e:
            org.json.JSONObject r7 = r10.c()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r5.put(r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0135:
            int r6 = r6 + 1
            goto L_0x006f
        L_0x0139:
            if (r18 == 0) goto L_0x0142
            org.json.JSONObject r6 = r2.c()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r5.put(r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0142:
            int r6 = r5.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 <= 0) goto L_0x014d
            java.lang.String r6 = "terminate"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x014d:
            java.util.Vector r6 = com.qihoo.stat.b.f28702a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 == 0) goto L_0x0177
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r8 = 0
        L_0x015c:
            java.util.Vector r10 = com.qihoo.stat.b.f28702a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 < r10) goto L_0x0165
            goto L_0x0179
        L_0x0165:
            java.util.Vector r10 = com.qihoo.stat.b.f28702a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.l r10 = (com.qihoo.stat.l) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r10 = r10.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r8 = r8 + 1
            goto L_0x015c
        L_0x0177:
            r6 = 0
            r7 = 0
        L_0x0179:
            java.util.Map r8 = r4.f28781b     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 == 0) goto L_0x01f1
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0185:
            boolean r10 = r8.hasNext()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 != 0) goto L_0x018c
            goto L_0x01f1
        L_0x018c:
            java.lang.Object r10 = r8.next()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r10 = (java.util.Vector) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r12 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r12 = r11.equals(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r12 == 0) goto L_0x01ca
            if (r7 != 0) goto L_0x01b2
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x01b2:
            r11 = 0
        L_0x01b3:
            int r12 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 < r12) goto L_0x01ba
            goto L_0x0185
        L_0x01ba:
            java.lang.Object r12 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.l r12 = (com.qihoo.stat.l) r12     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r12 = r12.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r11 = r11 + 1
            goto L_0x01b3
        L_0x01ca:
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r13 = 0
        L_0x01d0:
            int r14 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r13 < r14) goto L_0x01e1
            if (r6 != 0) goto L_0x01dd
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x01dd:
            r6.put(r11, r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0185
        L_0x01e1:
            java.lang.Object r14 = r10.get(r13)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.l r14 = (com.qihoo.stat.l) r14     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r14 = r14.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12.put(r14)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r13 = r13 + 1
            goto L_0x01d0
        L_0x01f1:
            if (r7 == 0) goto L_0x01fa
            if (r6 == 0) goto L_0x01fa
            java.lang.String r8 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x01fa:
            if (r6 == 0) goto L_0x0201
            java.lang.String r7 = "pay"
            r3.put(r7, r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0201:
            java.lang.String r6 = com.qihoo.stat.u.X(r17)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r6 = com.qihoo.stat.u.k(r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 != 0) goto L_0x0234
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.u.h(r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r8 = f28707a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = "Service EventArray size: "
            r10.<init>(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r11 = r7.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r10.append(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.g0.c(r8, r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0236
        L_0x0234:
            r6 = 0
            r7 = 0
        L_0x0236:
            java.util.Vector r8 = com.qihoo.stat.d0.f28721a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 == 0) goto L_0x0278
            int r8 = r8.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 <= 0) goto L_0x0278
            if (r6 != 0) goto L_0x0247
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0247:
            if (r7 != 0) goto L_0x024e
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x024e:
            r8 = 0
        L_0x024f:
            java.util.Vector r10 = com.qihoo.stat.d0.f28721a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 < r10) goto L_0x0258
            goto L_0x0278
        L_0x0258:
            java.util.Vector r10 = com.qihoo.stat.d0.f28721a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.i r10 = (com.qihoo.stat.i) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r18 != 0) goto L_0x026c
            java.lang.String r11 = "begin"
            java.lang.String r12 = r10.f28774c     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 != 0) goto L_0x0275
        L_0x026c:
            org.json.JSONObject r10 = r10.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 == 0) goto L_0x0275
            r7.put(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0275:
            int r8 = r8 + 1
            goto L_0x024f
        L_0x0278:
            java.util.Map r8 = r4.f28782c     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 == 0) goto L_0x02f4
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0284:
            boolean r10 = r8.hasNext()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 != 0) goto L_0x028b
            goto L_0x02f4
        L_0x028b:
            java.lang.Object r10 = r8.next()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r10 = (java.util.Vector) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r12 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r12 = r11.equals(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r12 == 0) goto L_0x02cb
            if (r7 != 0) goto L_0x02b1
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x02b1:
            r11 = 0
        L_0x02b2:
            int r12 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 < r12) goto L_0x02b9
            goto L_0x0284
        L_0x02b9:
            java.lang.Object r12 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.i r12 = (com.qihoo.stat.i) r12     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r12 = r12.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r12 == 0) goto L_0x02c8
            r7.put(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x02c8:
            int r11 = r11 + 1
            goto L_0x02b2
        L_0x02cb:
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r13 = 0
        L_0x02d1:
            int r14 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r13 < r14) goto L_0x02e2
            if (r6 != 0) goto L_0x02de
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x02de:
            r6.put(r11, r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0284
        L_0x02e2:
            java.lang.Object r14 = r10.get(r13)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.i r14 = (com.qihoo.stat.i) r14     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r14 = r14.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r14 == 0) goto L_0x02f1
            r12.put(r14)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x02f1:
            int r13 = r13 + 1
            goto L_0x02d1
        L_0x02f4:
            if (r7 == 0) goto L_0x0303
            int r8 = r7.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 <= 0) goto L_0x0303
            if (r6 == 0) goto L_0x0303
            java.lang.String r8 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0303:
            if (r6 == 0) goto L_0x0310
            int r7 = r6.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r7 <= 0) goto L_0x0310
            java.lang.String r7 = "event"
            r3.put(r7, r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0310:
            java.util.Vector r6 = com.qihoo.stat.h0.f28769a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 == 0) goto L_0x0346
            int r6 = r6.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 <= 0) goto L_0x0346
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r8 = 0
        L_0x0325:
            java.util.Vector r10 = com.qihoo.stat.h0.f28769a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 < r10) goto L_0x032e
            goto L_0x0348
        L_0x032e:
            java.util.Vector r10 = com.qihoo.stat.h0.f28769a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.k r10 = (com.qihoo.stat.k) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r18 != 0) goto L_0x033c
            int r11 = r10.f28792e     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r9 == r11) goto L_0x0343
        L_0x033c:
            org.json.JSONObject r10 = r10.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0343:
            int r8 = r8 + 1
            goto L_0x0325
        L_0x0346:
            r6 = 0
            r7 = 0
        L_0x0348:
            java.util.Map r8 = r4.f28783d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 == 0) goto L_0x03c0
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0354:
            boolean r10 = r8.hasNext()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 != 0) goto L_0x035b
            goto L_0x03c0
        L_0x035b:
            java.lang.Object r10 = r8.next()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r10 = (java.util.Vector) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r12 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r12 = r11.equals(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r12 == 0) goto L_0x0399
            if (r7 != 0) goto L_0x0381
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0381:
            r11 = 0
        L_0x0382:
            int r12 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 < r12) goto L_0x0389
            goto L_0x0354
        L_0x0389:
            java.lang.Object r12 = r10.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.k r12 = (com.qihoo.stat.k) r12     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r12 = r12.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r11 = r11 + 1
            goto L_0x0382
        L_0x0399:
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r13 = 0
        L_0x039f:
            int r14 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r13 < r14) goto L_0x03b0
            if (r6 != 0) goto L_0x03ac
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x03ac:
            r6.put(r11, r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0354
        L_0x03b0:
            java.lang.Object r14 = r10.get(r13)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.k r14 = (com.qihoo.stat.k) r14     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r14 = r14.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12.put(r14)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r13 = r13 + 1
            goto L_0x039f
        L_0x03c0:
            if (r7 == 0) goto L_0x03cf
            int r8 = r7.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 <= 0) goto L_0x03cf
            if (r6 == 0) goto L_0x03cf
            java.lang.String r8 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x03cf:
            if (r6 == 0) goto L_0x03dc
            int r7 = r6.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r7 <= 0) goto L_0x03dc
            java.lang.String r7 = "level"
            r3.put(r7, r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x03dc:
            java.util.Vector r6 = com.qihoo.stat.s.f28840a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 == 0) goto L_0x0412
            int r6 = r6.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 <= 0) goto L_0x0412
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r8 = 0
        L_0x03f1:
            java.util.Vector r10 = com.qihoo.stat.s.f28840a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 < r10) goto L_0x03fa
            goto L_0x0414
        L_0x03fa:
            java.util.Vector r10 = com.qihoo.stat.s.f28840a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.o r10 = (com.qihoo.stat.o) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r18 != 0) goto L_0x0408
            int r11 = r10.f28825d     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r9 == r11) goto L_0x040f
        L_0x0408:
            org.json.JSONObject r10 = r10.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x040f:
            int r8 = r8 + 1
            goto L_0x03f1
        L_0x0412:
            r6 = 0
            r7 = 0
        L_0x0414:
            java.util.Map r8 = r4.f28784e     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 == 0) goto L_0x048c
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0420:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r9 != 0) goto L_0x0427
            goto L_0x048c
        L_0x0427:
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r9.getKey()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r9 = (java.util.Vector) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 == 0) goto L_0x0465
            if (r7 != 0) goto L_0x044d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x044d:
            r10 = 0
        L_0x044e:
            int r11 = r9.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 < r11) goto L_0x0455
            goto L_0x0420
        L_0x0455:
            java.lang.Object r11 = r9.get(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.o r11 = (com.qihoo.stat.o) r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r11 = r11.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10 + 1
            goto L_0x044e
        L_0x0465:
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r11.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12 = 0
        L_0x046b:
            int r13 = r9.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r12 < r13) goto L_0x047c
            if (r6 != 0) goto L_0x0478
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0478:
            r6.put(r10, r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0420
        L_0x047c:
            java.lang.Object r13 = r9.get(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.o r13 = (com.qihoo.stat.o) r13     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r13 = r13.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r11.put(r13)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r12 = r12 + 1
            goto L_0x046b
        L_0x048c:
            if (r7 == 0) goto L_0x049b
            int r8 = r7.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 <= 0) goto L_0x049b
            if (r6 == 0) goto L_0x049b
            java.lang.String r8 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x049b:
            if (r6 == 0) goto L_0x04a8
            int r7 = r6.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r7 <= 0) goto L_0x04a8
            java.lang.String r7 = "task"
            r3.put(r7, r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x04a8:
            java.util.Vector r6 = com.qihoo.stat.a0.f28700a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 == 0) goto L_0x04d2
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r8 = 0
        L_0x04b7:
            java.util.Vector r9 = com.qihoo.stat.a0.f28700a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r9 = r9.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 < r9) goto L_0x04c0
            goto L_0x04d4
        L_0x04c0:
            java.util.Vector r9 = com.qihoo.stat.a0.f28700a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.h r9 = (com.qihoo.stat.h) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r9 = r9.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r9)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r8 = r8 + 1
            goto L_0x04b7
        L_0x04d2:
            r6 = 0
            r7 = 0
        L_0x04d4:
            java.util.Map r8 = r4.f28785f     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 == 0) goto L_0x054c
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x04e0:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r9 != 0) goto L_0x04e7
            goto L_0x054c
        L_0x04e7:
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r10 = r9.getKey()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r9 = (java.util.Vector) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r11 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r11 = r10.equals(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 == 0) goto L_0x0525
            if (r7 != 0) goto L_0x050d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x050d:
            r10 = 0
        L_0x050e:
            int r11 = r9.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 < r11) goto L_0x0515
            goto L_0x04e0
        L_0x0515:
            java.lang.Object r11 = r9.get(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.h r11 = (com.qihoo.stat.h) r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r11 = r11.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10 + 1
            goto L_0x050e
        L_0x0525:
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r11.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r12 = 0
        L_0x052b:
            int r13 = r9.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r12 < r13) goto L_0x053c
            if (r6 != 0) goto L_0x0538
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0538:
            r6.put(r10, r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x04e0
        L_0x053c:
            java.lang.Object r13 = r9.get(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.h r13 = (com.qihoo.stat.h) r13     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r13 = r13.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r11.put(r13)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r12 = r12 + 1
            goto L_0x052b
        L_0x054c:
            if (r7 == 0) goto L_0x0555
            if (r6 == 0) goto L_0x0555
            java.lang.String r8 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0555:
            if (r6 == 0) goto L_0x055c
            java.lang.String r7 = "buy"
            r3.put(r7, r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x055c:
            java.util.Vector r6 = com.qihoo.stat.t.f28842a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 == 0) goto L_0x0588
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r8 = 0
        L_0x056b:
            java.util.Vector r9 = com.qihoo.stat.t.f28842a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r9 = r9.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 < r9) goto L_0x0576
            r16 = r6
            goto L_0x058b
        L_0x0576:
            java.util.Vector r9 = com.qihoo.stat.t.f28842a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.p r9 = (com.qihoo.stat.p) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r9 = r9.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r6.put(r9)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r8 = r8 + 1
            goto L_0x056b
        L_0x0588:
            r7 = 0
            r16 = 0
        L_0x058b:
            java.util.Map r6 = r4.f28786g     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r6 == 0) goto L_0x0607
            java.util.Set r6 = r6.entrySet()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0597:
            boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r8 != 0) goto L_0x059e
            goto L_0x0607
        L_0x059e:
            java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r9 = r8.getKey()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.Object r8 = r8.getValue()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.util.Vector r8 = (java.util.Vector) r8     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r10 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            boolean r10 = r9.equals(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 == 0) goto L_0x05e0
            if (r16 != 0) goto L_0x05c4
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONArray r16 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r16.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x05c4:
            r9 = r16
            r10 = 0
        L_0x05c7:
            int r11 = r8.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r10 < r11) goto L_0x05d0
            r16 = r9
            goto L_0x0597
        L_0x05d0:
            java.lang.Object r11 = r8.get(r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.p r11 = (com.qihoo.stat.p) r11     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r11 = r11.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r9.put(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r10 = r10 + 1
            goto L_0x05c7
        L_0x05e0:
            org.json.JSONArray r10 = new org.json.JSONArray     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r10.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r11 = 0
        L_0x05e6:
            int r12 = r8.size()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r11 < r12) goto L_0x05f7
            if (r7 != 0) goto L_0x05f3
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.<init>()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x05f3:
            r7.put(r9, r10)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0597
        L_0x05f7:
            java.lang.Object r12 = r8.get(r11)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.p r12 = (com.qihoo.stat.p) r12     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r12 = r12.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r10.put(r12)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r11 = r11 + 1
            goto L_0x05e6
        L_0x0607:
            r6 = r16
            if (r6 == 0) goto L_0x0612
            if (r7 == 0) goto L_0x0612
            java.lang.String r8 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7.put(r8, r6)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0612:
            if (r7 == 0) goto L_0x0619
            java.lang.String r6 = "use"
            r3.put(r6, r7)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0619:
            com.qihoo.stat.f0 r6 = new com.qihoo.stat.f0     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            int r5 = r5.length()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r7 = r17
            r6.<init>(r7, r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r5 = r6.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r6 = "header"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r5 = com.qihoo.stat.c.d(r17)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r5 == 0) goto L_0x0638
            java.lang.String r6 = "player"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0638:
            java.lang.String r5 = r2.f28815a     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            org.json.JSONObject r5 = com.qihoo.stat.e0.a(r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r5 == 0) goto L_0x0645
            java.lang.String r6 = "exception"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0645:
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r3 = com.qihoo.stat.u.n(r3)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            java.lang.String r5 = com.qihoo.stat.u.S(r17)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.u.g(r5, r3)     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            if (r18 == 0) goto L_0x0659
            r2.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
        L_0x0659:
            com.qihoo.stat.b.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.d0.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.h0.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.s.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.a0.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.t.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            com.qihoo.stat.c.b()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            r4.a()     // Catch:{ Exception -> 0x067d, Error -> 0x0675 }
            goto L_0x0684
        L_0x0672:
            r0 = move-exception
            r2 = r0
            goto L_0x0686
        L_0x0675:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = f28707a     // Catch:{ all -> 0x0672 }
            com.qihoo.stat.g0.a(r3, r2)     // Catch:{ all -> 0x0672 }
            goto L_0x0684
        L_0x067d:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = f28707a     // Catch:{ all -> 0x0672 }
            com.qihoo.stat.g0.b(r3, r2)     // Catch:{ all -> 0x0672 }
        L_0x0684:
            monitor-exit(r1)
            return
        L_0x0686:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.c0.d(android.content.Context, boolean):void");
    }

    public static long e(Context context, String str, long j11) {
        return context.getSharedPreferences("qihoo_game_session_info", 0).getLong(str, j11);
    }

    public static String f(Context context, String str) {
        String k11 = k(context);
        if ("qch_default".equals(k11)) {
            return context.getSharedPreferences("qihoo_game_session_info", 0).getString(AppsFlyerProperties.CHANNEL, str);
        }
        if (k11.length() != 16) {
            return k11;
        }
        if (!k11.startsWith("qch_" + u.K())) {
            return k11;
        }
        if (!(String.valueOf(u.A()) + u.C()).equals(u.f(k11.substring(10)))) {
            return k11;
        }
        d.f28710b = true;
        return "";
    }

    public static String g(Context context, String str, String str2) {
        return context.getSharedPreferences("qihoo_game_session_info", 0).getString(str, str2);
    }

    public static void h(Context context) {
        SharedPreferences.Editor editor;
        SharedPreferences sharedPreferences = context.getSharedPreferences("qihoo_game_session_info", 0);
        String g11 = g(context, MTPushConstants.NotificationTime.KEY_DAYS, "");
        String I = u.I();
        if (I.equals(g11)) {
            editor = sharedPreferences.edit().putLong("todaySession", sharedPreferences.getLong("todaySession", 0) + 1);
        } else {
            sharedPreferences.edit().putString(MTPushConstants.NotificationTime.KEY_DAYS, I).commit();
            editor = sharedPreferences.edit().putLong("todaySession", 1);
        }
        editor.commit();
    }

    public static void i(Context context) {
        if ("true".equals(g(context, "enableMode", "true"))) {
            context.getSharedPreferences("qihoo_game_session_info", 0).edit().putString("dataMode", d.f31895b).commit();
            d.f28720l = false;
        }
    }

    public static void j(Context context) {
        context.getSharedPreferences("qihoo_game_session_info", 0).edit().putString("dataMode", "true").commit();
        d.f28720l = true;
    }

    public static String k(Context context) {
        try {
            if (!TextUtils.isEmpty(f28708b)) {
                return f28708b;
            }
            String str = context.getApplicationInfo().sourceDir;
            if (TextUtils.isEmpty(str)) {
                return "qch_default";
            }
            String b11 = y.b(str);
            if (TextUtils.isEmpty(b11)) {
                return "qch_default";
            }
            if (b11.startsWith("err") && b11.length() > 3) {
                b11 = "qch_" + "default" + b11.substring(3);
            }
            if (TextUtils.isEmpty(b11)) {
                return "qch_default";
            }
            f28708b = b11;
            return b11;
        } catch (Exception e11) {
            g0.b(f28707a, e11);
            return "qch_default";
        }
    }
}
