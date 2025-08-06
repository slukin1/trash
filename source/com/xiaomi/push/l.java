package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

public abstract class l {
    public static void a(Context context) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2918a(Context context, String str, boolean z11) {
        a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z11);
    }

    public static void a(Context context, String str, boolean z11) {
        a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z11).commit();
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map != null && str != null && str2 != null) {
            map.put(str, str2);
        }
    }
}
