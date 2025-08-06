package com.engagelab.privates.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.LinkedHashSet;
import java.util.Set;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f64962a;

    public static void a(Context context, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 11) {
            j(context).edit().putStringSet("http_address", set).commit();
        }
    }

    public static void b(Context context, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 11) {
            j(context).edit().putStringSet("tcp_address", set).commit();
        }
    }

    public static void c(Context context, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 11) {
            j(context).edit().putStringSet("udp_address", set).commit();
        }
    }

    public static String d(Context context) {
        return j(context).getString(MTCoreConstants.Register.KEY_PASSWORD, "");
    }

    public static byte e(Context context) {
        return (byte) j(context).getInt("platform_state", 0);
    }

    public static int f(Context context) {
        return j(context).getInt("register_code", -1);
    }

    public static String g(Context context) {
        return j(context).getString(MTCoreConstants.Register.KEY_REGISTRATION_ID, "");
    }

    public static int h(Context context) {
        return f64962a.getInt(MTCoreConstants.Login.KEY_SEED_ID, 0);
    }

    public static long i(Context context) {
        return j(context).getLong("server_time", 0);
    }

    public static SharedPreferences j(Context context) {
        if (f64962a == null) {
            f64962a = context.getSharedPreferences("com.engagelab.privates.core.prefs", 0);
        }
        return f64962a;
    }

    public static Set<String> k(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            return new LinkedHashSet();
        }
        return j(context).getStringSet("tcp_address", new LinkedHashSet());
    }

    public static Set<String> l(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            return new LinkedHashSet();
        }
        return j(context).getStringSet("udp_address", new LinkedHashSet());
    }

    public static long m(Context context) {
        return j(context).getLong("user_id", 0);
    }

    public static void a(Context context, String str) {
        j(context).edit().putString(MTCoreConstants.Register.KEY_PASSWORD, str).commit();
    }

    public static Set<String> b(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            return new LinkedHashSet();
        }
        return j(context).getStringSet("http_address", new LinkedHashSet());
    }

    public static int c(Context context) {
        return j(context).getInt("login_code", -1);
    }

    public static void a(Context context, int i11) {
        j(context).edit().putInt("login_code", i11).commit();
    }

    public static void c(Context context, int i11) {
        j(context).edit().putInt(MTCoreConstants.Login.KEY_SEED_ID, i11).commit();
    }

    public static void a(Context context, long j11) {
        j(context).edit().putLong("server_time", j11).commit();
    }

    public static boolean a(Context context) {
        return j(context).getBoolean("connect_state", true);
    }

    public static void b(Context context, int i11) {
        j(context).edit().putInt("register_code", i11).commit();
    }

    public static void a(Context context, boolean z11) {
        j(context).edit().putBoolean("connect_state", z11).commit();
    }

    public static void b(Context context, long j11) {
        j(context).edit().putLong("user_id", j11).commit();
    }

    public static void a(Context context, byte b11) {
        j(context).edit().putInt("platform_state", b11).commit();
    }

    public static void b(Context context, String str) {
        j(context).edit().putString(MTCoreConstants.Register.KEY_REGISTRATION_ID, str).commit();
    }
}
