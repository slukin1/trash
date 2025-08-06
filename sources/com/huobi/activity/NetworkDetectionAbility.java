package com.huobi.activity;

import android.content.Context;
import com.huobi.edgeengine.ability.s;
import i6.l;
import pro.huobi.R;

public class NetworkDetectionAbility implements s {
    /* JADX WARNING: Can't wrap try/catch for region: R(36:3|(2:4|5)|6|(2:8|9)|10|(2:12|13)|14|(2:16|17)|18|(2:20|21)|22|(2:24|25)|26|(2:28|29)|30|32|33|34|35|(2:36|37)|40|(2:41|42)|43|(2:45|46)|47|49|50|(1:52)(1:53)|54|55|56|57|58|(1:60)|61|63) */
    /* JADX WARNING: Can't wrap try/catch for region: R(43:3|4|5|6|8|9|10|(2:12|13)|14|16|17|18|20|21|22|(2:24|25)|26|28|29|30|32|33|34|35|36|37|40|41|42|43|(2:45|46)|47|49|50|(1:52)(1:53)|54|55|56|57|58|(1:60)|61|63) */
    /* JADX WARNING: Can't wrap try/catch for region: R(45:3|4|5|6|8|9|10|(2:12|13)|14|16|17|18|20|21|22|24|25|26|28|29|30|32|33|34|35|36|37|40|41|42|43|45|46|47|49|50|(1:52)(1:53)|54|55|56|57|58|(1:60)|61|63) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00a6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00de */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e A[Catch:{ all -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1 A[Catch:{ all -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e4 A[Catch:{ all -> 0x00e9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(rj.b r6, java.lang.Object r7, com.huobi.edgeengine.ability.AbilityFunction.a r8) {
        /*
            r5 = this;
            java.lang.String r7 = ""
            java.lang.String r0 = "networkOperator"
            if (r8 != 0) goto L_0x0007
            return
        L_0x0007:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "phone"
            java.lang.String r3 = com.hbg.lib.core.util.PhoneUtils.f()     // Catch:{ all -> 0x0015 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0015 }
        L_0x0015:
            java.lang.String r2 = "version"
            android.content.Context r3 = r6.d()     // Catch:{ all -> 0x0022 }
            java.lang.String r3 = com.hbg.lib.core.util.PhoneUtils.d(r3)     // Catch:{ all -> 0x0022 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0022 }
        L_0x0022:
            java.lang.String r2 = "vtoken"
            ku.b r3 = ku.b.e()     // Catch:{ all -> 0x0033 }
            android.content.Context r4 = r6.d()     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = r3.h(r4)     // Catch:{ all -> 0x0033 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0033 }
        L_0x0033:
            java.lang.String r2 = "osVersion"
            java.lang.String r3 = com.hbg.lib.core.util.PhoneUtils.g()     // Catch:{ all -> 0x003c }
            r1.put(r2, r3)     // Catch:{ all -> 0x003c }
        L_0x003c:
            java.lang.String r2 = "screenWidth"
            android.content.Context r3 = r6.d()     // Catch:{ all -> 0x0049 }
            int r3 = i6.n.g(r3)     // Catch:{ all -> 0x0049 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0049 }
        L_0x0049:
            java.lang.String r2 = "screenHeight"
            android.content.Context r3 = r6.d()     // Catch:{ all -> 0x0056 }
            int r3 = i6.n.f(r3)     // Catch:{ all -> 0x0056 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0056 }
        L_0x0056:
            java.lang.String r2 = "language"
            java.lang.String r3 = com.hbg.lib.core.util.p.b()     // Catch:{ all -> 0x005f }
            r1.put(r2, r3)     // Catch:{ all -> 0x005f }
        L_0x005f:
            java.lang.String r2 = "ip"
            android.content.Context r3 = r6.d()     // Catch:{ all -> 0x006c }
            java.lang.String r3 = i6.l.d(r3)     // Catch:{ all -> 0x006c }
            r1.put(r2, r3)     // Catch:{ all -> 0x006c }
        L_0x006c:
            java.lang.String r2 = com.hbg.lib.core.util.PhoneUtils.o()     // Catch:{ all -> 0x0074 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0074 }
            goto L_0x007c
        L_0x0074:
            r1.put(r0, r7)     // Catch:{ JSONException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007c:
            java.lang.String r0 = "dns"
            android.content.Context r2 = r6.d()     // Catch:{ all -> 0x0089 }
            java.lang.String r2 = i6.l.c(r2)     // Catch:{ all -> 0x0089 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0089 }
        L_0x0089:
            java.lang.String r0 = "networkType"
            android.content.Context r6 = r6.d()     // Catch:{ all -> 0x0096 }
            java.lang.String r6 = r5.b(r6)     // Catch:{ all -> 0x0096 }
            r1.put(r0, r6)     // Catch:{ all -> 0x0096 }
        L_0x0096:
            java.lang.String r6 = "vpn"
            boolean r0 = i6.l.j()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x00a1
            java.lang.String r0 = "true"
            goto L_0x00a3
        L_0x00a1:
            java.lang.String r0 = "false"
        L_0x00a3:
            r1.put(r6, r0)     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            sn.a r6 = sn.a.c()     // Catch:{ Exception -> 0x00de }
            java.lang.String r6 = r6.a()     // Catch:{ Exception -> 0x00de }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x00de }
            int r6 = r6 * 37
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00de }
            sn.a r0 = sn.a.c()     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x00de }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00de }
            int r0 = r0 * 37
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00de }
            r2.<init>()     // Catch:{ Exception -> 0x00de }
            r2.append(r6)     // Catch:{ Exception -> 0x00de }
            java.lang.String r6 = "/"
            r2.append(r6)     // Catch:{ Exception -> 0x00de }
            r2.append(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r7 = r2.toString()     // Catch:{ Exception -> 0x00de }
        L_0x00de:
            boolean r6 = com.hbg.lib.common.utils.StringUtils.q(r7)     // Catch:{ all -> 0x00e9 }
            if (r6 == 0) goto L_0x00e9
            java.lang.String r6 = "region"
            r1.put(r6, r7)     // Catch:{ all -> 0x00e9 }
        L_0x00e9:
            r6 = 1
            java.lang.String r7 = r1.toString()
            r8.a(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.activity.NetworkDetectionAbility.a(rj.b, java.lang.Object, com.huobi.edgeengine.ability.AbilityFunction$a):void");
    }

    public final String b(Context context) {
        if (!l.k(context)) {
            return l.m(context) ? "Wi-Fi" : "None";
        }
        if (!l.m(context)) {
            return context.getString(R.string.network_cellular);
        }
        return context.getString(R.string.network_cellular) + " + Wi-Fi";
    }
}
