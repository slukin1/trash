package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

public class q {
    public static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) s.a((Context) null, "android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e11) {
            b.a("SystemProperties.get: " + e11);
            return str2;
        }
    }
}
