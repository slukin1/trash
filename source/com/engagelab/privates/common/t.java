package com.engagelab.privates.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.LinkedHashSet;
import java.util.Set;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f64981a;

    public static String a(Context context, int i11) {
        SharedPreferences j11 = j(context);
        return j11.getString("notification_layout_" + i11, "");
    }

    public static void b(Context context, int i11) {
        j(context).edit().putInt(MTPushConstants.NotificationBadge.KEY_BADGE, i11).commit();
    }

    public static void c(Context context, String str) {
        j(context).edit().putString("notification_show_time", str).commit();
    }

    public static void d(Context context, String str) {
        j(context).edit().putString("notification_silence_time", str).commit();
    }

    public static int e(Context context) {
        return j(context).getInt(MTPushConstants.NotificationCount.KEY_COUNT, 5);
    }

    public static String f(Context context) {
        return j(context).getString("notification_show_time", "");
    }

    public static String g(Context context) {
        return j(context).getString("notification_silence_time", "");
    }

    public static Set<String> h(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return j(context).getStringSet("override_message_id_set", new LinkedHashSet());
        }
        return new LinkedHashSet();
    }

    public static Set<String> i(Context context) {
        if (Build.VERSION.SDK_INT >= 11) {
            return j(context).getStringSet("revoke_message_id_set", new LinkedHashSet());
        }
        return new LinkedHashSet();
    }

    public static SharedPreferences j(Context context) {
        if (f64981a == null) {
            f64981a = context.getApplicationContext().getSharedPreferences("com.engagelab.privates.push.prefs", 0);
        }
        return f64981a;
    }

    public static void a(Context context, int i11, String str) {
        SharedPreferences.Editor edit = j(context).edit();
        edit.putString("notification_layout_" + i11, str).commit();
    }

    public static void b(Context context, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 11) {
            j(context).edit().putStringSet("revoke_message_id_set", set).commit();
        }
    }

    public static void c(Context context, int i11) {
        j(context).edit().putInt(MTPushConstants.NotificationCount.KEY_COUNT, i11).commit();
    }

    public static int d(Context context) {
        return j(context).getInt(MTPushConstants.NotificationBadge.KEY_BADGE, 0);
    }

    public static Set<String> a(Context context, byte b11) {
        if (Build.VERSION.SDK_INT < 11) {
            return new LinkedHashSet();
        }
        SharedPreferences j11 = j(context);
        return j11.getStringSet("message_id_set_" + b11, new LinkedHashSet());
    }

    public static long c(Context context) {
        return j(context).getLong("last_to_background_time", 0);
    }

    public static String b(Context context, byte b11) {
        SharedPreferences j11 = j(context);
        return j11.getString("platform_token_" + b11, "");
    }

    public static void b(Context context, long j11) {
        j(context).edit().putLong("last_to_foreground_time", j11).commit();
    }

    public static void a(Context context, byte b11, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 11) {
            SharedPreferences.Editor edit = j(context).edit();
            edit.putStringSet("message_id_set_" + b11, set).commit();
        }
    }

    public static String b(Context context) {
        return j(context).getString("last_lifecycle_session_json", "");
    }

    public static void b(Context context, String str) {
        j(context).edit().putString("last_lifecycle_session_json", str).commit();
    }

    public static void a(Context context, Set<String> set) {
        if (Build.VERSION.SDK_INT >= 11) {
            j(context).edit().putStringSet("override_message_id_set", set).commit();
        }
    }

    public static void a(Context context, byte b11, String str) {
        SharedPreferences.Editor edit = j(context).edit();
        edit.putString("platform_token_" + b11, str).commit();
    }

    public static void a(Context context, long j11) {
        j(context).edit().putLong("last_to_background_time", j11).commit();
    }

    public static String a(Context context) {
        return j(context).getString("last_lifecycle_session", "");
    }

    public static void a(Context context, String str) {
        j(context).edit().putString("last_lifecycle_session", str).commit();
    }
}
