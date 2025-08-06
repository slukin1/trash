package com.xiaomi.push;

import android.os.Build;
import com.hbg.lib.network.pro.core.util.Period;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static long f52372a;

    /* renamed from: a  reason: collision with other field name */
    private static String f3253a;

    public static synchronized String a() {
        String str;
        synchronized (k.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f52372a) > Period.DAY_MILLS) {
                f52372a = currentTimeMillis;
                f3253a = Build.MODEL;
            }
            str = f3253a;
            if (str == null) {
                str = "";
            }
        }
        return str;
    }
}
