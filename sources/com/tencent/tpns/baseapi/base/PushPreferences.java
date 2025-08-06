package com.tencent.tpns.baseapi.base;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.tpns.baseapi.crosssp.a;

public class PushPreferences {

    /* renamed from: a  reason: collision with root package name */
    private static a f49745a;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (PushPreferences.class) {
            if (f49745a == null) {
                f49745a = a.a(context);
            }
            aVar = f49745a;
        }
        return aVar;
    }

    public static boolean getBoolean(Context context, String str, boolean z11) {
        return a(context).a(str, z11);
    }

    public static float getFloat(Context context, String str, float f11) {
        return a(context).a(str, f11);
    }

    public static int getInt(Context context, String str, int i11) {
        return a(context).a(str, i11);
    }

    public static long getLong(Context context, String str, long j11) {
        return a(context).a(str, j11);
    }

    public static Object getObject(Context context, String str, String str2) {
        return a(context).b(str, str2);
    }

    public static String getString(Context context, String str, String str2) {
        return a(context).a(str, str2);
    }

    public static void putBoolean(Context context, String str, boolean z11) {
        a.C0633a a11 = a(context).a();
        a11.a(str, z11);
        a11.b();
    }

    public static void putContentValues(Context context, ContentValues contentValues) {
        a.C0633a a11 = a(context).a();
        a11.a(contentValues);
        a11.b();
    }

    public static void putFloat(Context context, String str, float f11) {
        a.C0633a a11 = a(context).a();
        a11.a(str, f11);
        a11.b();
    }

    public static void putInt(Context context, String str, int i11) {
        a.C0633a a11 = a(context).a();
        a11.a(str, i11);
        a11.b();
    }

    public static void putLong(Context context, String str, long j11) {
        a.C0633a a11 = a(context).a();
        a11.a(str, j11);
        a11.b();
    }

    public static void putString(Context context, String str, String str2) {
        a.C0633a a11 = a(context).a();
        a11.a(str, str2);
        a11.b();
    }

    public static void remove(Context context, String str) {
        if (a(context) != null) {
            a.C0633a a11 = a(context).a();
            a11.a(str);
            a11.b();
        }
    }
}
