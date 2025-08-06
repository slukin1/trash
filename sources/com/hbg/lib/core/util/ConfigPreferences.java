package com.hbg.lib.core.util;

import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.network.pro.core.util.Period;
import i6.d;
import i6.m;

public class ConfigPreferences {
    public static boolean a(String str, String str2) {
        return SP.b(str, str2);
    }

    public static boolean b(String str, String str2) {
        return SP.k(str, str2, false);
    }

    public static boolean c(String str, String str2, boolean z11) {
        return SP.k(str, str2, z11);
    }

    public static String d(String str, String str2) {
        return Uri.decode(SP.j(str, str2, ""));
    }

    public static String e(String str, String str2, String str3) {
        String j11 = SP.j(str, str2, str3);
        return !j11.equals(str3) ? Uri.decode(j11) : j11;
    }

    public static int f(String str, String str2) {
        try {
            return m.k0(d(str, str2));
        } catch (Exception e11) {
            d.g(e11);
            return 0;
        }
    }

    public static int g(String str, String str2, int i11) {
        return m.k0(e(str, str2, i11 + ""));
    }

    public static long h(String str, String str2) {
        return m.m0(d(str, str2));
    }

    public static long i(String str, String str2, long j11) {
        return m.m0(e(str, str2, j11 + ""));
    }

    public static boolean j(Context context) {
        long j11 = PreferenceManager.getDefaultSharedPreferences(context).getLong("HOMEACTIVITY_SHOWTIME_KEY", 0);
        if (j11 != 0 && System.currentTimeMillis() - j11 < Period.DAY_MILLS) {
            return false;
        }
        return true;
    }

    public static boolean k(String str, String str2, int i11) {
        return m(str, str2, String.valueOf(i11));
    }

    public static boolean l(String str, String str2, long j11) {
        return m(str, str2, String.valueOf(j11));
    }

    public static boolean m(String str, String str2, String str3) {
        SP.w(str, str2, str3);
        return true;
    }

    public static boolean n(String str, String str2, boolean z11) {
        SP.x(str, str2, z11);
        return true;
    }
}
