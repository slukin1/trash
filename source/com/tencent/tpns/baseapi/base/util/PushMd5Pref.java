package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;

public class PushMd5Pref {
    private PushMd5Pref() {
    }

    private static String a(String str) {
        return Md5.md5(str);
    }

    public static float getFloat(Context context, String str, float f11) {
        try {
            return PushPreferences.getFloat(context, a(str), f11);
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "getFloat", th2);
            return 0.0f;
        }
    }

    public static int getInt(Context context, String str, int i11) {
        try {
            return PushPreferences.getInt(context, a(str), i11);
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "getInt", th2);
            return 0;
        }
    }

    public static long getLong(Context context, String str, long j11) {
        try {
            return PushPreferences.getLong(context, a(str), j11);
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "getLong", th2);
            return 0;
        }
    }

    public static String getString(Context context, String str, boolean z11) {
        if (!z11) {
            return PushPreferences.getString(context, a(str), (String) null);
        }
        try {
            String str2 = (String) MemoryCacheManager.get(str);
            if (str2 != null) {
                return str2;
            }
            String string = PushPreferences.getString(context, a(str), (String) null);
            MemoryCacheManager.put(str, string);
            return string;
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "getString", th2);
            return "";
        }
    }

    public static boolean putFloat(Context context, String str, float f11) {
        try {
            PushPreferences.putFloat(context, a(str), f11);
            return true;
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "putFloat", th2);
            return false;
        }
    }

    public static boolean putInt(Context context, String str, int i11) {
        try {
            PushPreferences.putInt(context, a(str), i11);
            return true;
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "putInt", th2);
            return false;
        }
    }

    public static boolean putLong(Context context, String str, long j11) {
        try {
            PushPreferences.putLong(context, a(str), j11);
            return false;
        } catch (Throwable th2) {
            Logger.e("PushMd5Pref", "putLong", th2);
            return false;
        }
    }

    public static boolean putString(Context context, String str, String str2, boolean z11) {
        if (z11) {
            try {
                String str3 = (String) MemoryCacheManager.get(str);
                if (str3 != null && str2 != null && str3.equals(str2)) {
                    return true;
                }
                MemoryCacheManager.put(str, str2);
            } catch (Throwable th2) {
                Logger.e("PushMd5Pref", "putString", th2);
                return false;
            }
        }
        PushPreferences.putString(context, a(str), str2);
        return true;
    }
}
