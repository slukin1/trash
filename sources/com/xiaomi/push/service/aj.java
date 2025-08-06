package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;

public class aj {

    /* renamed from: a  reason: collision with root package name */
    private static long f52460a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static String f3332a = "";

    public static String a() {
        if (TextUtils.isEmpty(f3332a)) {
            f3332a = bc.a(4);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f3332a);
        long j11 = f52460a;
        f52460a = 1 + j11;
        sb2.append(j11);
        return sb2.toString();
    }

    public static String b() {
        return bc.a(32);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return str;
        }
        try {
            return "BlockId_" + str.substring(8);
        } catch (Exception e11) {
            b.d("Exception occurred when filtering registration packet id for log. " + e11);
            return "UnexpectedId";
        }
    }
}
