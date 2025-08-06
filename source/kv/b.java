package kv;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.huobi.woodpecker.WoodPeckerSDK;

public class b {
    public static String a(Context context, String str, String str2) {
        return c(context).getString(str, str2);
    }

    public static boolean b(Context context, String str, boolean z11) {
        return c(context).getBoolean(str, z11);
    }

    public static final SharedPreferences c(Context context) {
        if (context != null) {
            return context.getSharedPreferences("woodpecker_sdk_storage", 0);
        }
        return PreferenceManager.getDefaultSharedPreferences(WoodPeckerSDK.f().e());
    }

    public static void d(Context context, String str, String str2) {
        c(context).edit().putString(str, str2).commit();
    }

    public static void e(Context context, String str, boolean z11) {
        c(context).edit().putBoolean(str, z11).commit();
    }
}
