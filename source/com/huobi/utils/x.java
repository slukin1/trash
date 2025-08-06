package com.huobi.utils;

import android.text.TextUtils;
import android.util.Log;
import bh.j;
import com.hbg.lib.core.util.ConfigPreferences;
import java.util.Arrays;
import java.util.Collection;
import java.util.TimeZone;
import pro.huobi.R;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static String f83790a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f83791b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f83792c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f83793d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f83794e = false;

    public static String a() {
        return f83791b;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f83790a)) {
            return f83790a;
        }
        String e11 = ConfigPreferences.e("user_config", "CUR_IP_COUNTRY_TYPE", "1");
        if (TextUtils.isEmpty(e11)) {
            return null;
        }
        f83790a = e11;
        return e11;
    }

    public static boolean c() {
        String[] stringArray = j.c().getResources().getStringArray(R.array.china_timezone);
        String id2 = TimeZone.getDefault().getID();
        Log.i("domain", "timezone = " + id2);
        Log.i("domain", "isChinaTimeZone = " + Arrays.asList(stringArray).contains(id2));
        return Arrays.asList(stringArray).contains(id2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (c() == false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d() {
        /*
            sn.a r0 = sn.a.c()
            java.lang.String r0 = r0.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "countryId: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "DomainUtil"
            i6.k.o(r2, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0030
            java.lang.String r1 = "37"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x002f
            return r3
        L_0x002f:
            return r2
        L_0x0030:
            boolean r0 = f83794e
            if (r0 == 0) goto L_0x0037
            boolean r0 = f83793d
            return r0
        L_0x0037:
            android.app.Application r0 = bh.j.c()     // Catch:{ Exception -> 0x0048 }
            boolean r0 = com.hbg.lib.common.network.NetworkStatus.b(r0)     // Catch:{ Exception -> 0x0048 }
            if (r0 != 0) goto L_0x004c
            boolean r0 = c()     // Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x004d
            goto L_0x004c
        L_0x0048:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004c:
            r2 = r3
        L_0x004d:
            f83794e = r3
            f83793d = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.x.d():boolean");
    }

    public static boolean e(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static void f(String str) {
        f83791b = str;
        String str2 = "37".equals(str) ? "1" : "2";
        if (!TextUtils.isEmpty(str2)) {
            f83790a = str2;
            ConfigPreferences.m("user_config", "CUR_IP_COUNTRY_TYPE", str2);
        }
    }

    public static void g(boolean z11) {
        f83792c = z11;
    }
}
