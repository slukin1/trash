package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

class al {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f51380a = false;

    private static void a(Class<?> cls, Context context) {
        if (!f51380a) {
            try {
                f51380a = true;
                cls.getDeclaredMethod("InitEntry", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            } catch (Throwable th2) {
                b.a("mdid:load lib error " + th2);
            }
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> a11 = s.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a11 == null) {
                return false;
            }
            a(a11, context);
            return true;
        } catch (Throwable th2) {
            b.a("mdid:check error " + th2);
            return false;
        }
    }
}
