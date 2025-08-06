package com.tencent.tpns.dataacquisition.b;

import android.content.Context;
import android.util.Log;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f49921a = true;

    public static void a(Object obj) {
        if (f49921a) {
            Log.w("TPush-DataAcq", "" + obj);
        }
    }

    public static void a(String str, Throwable th2) {
        Log.e("TPush-DataAcq", "" + str, th2);
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th2) {
            a("checkPermission error", th2);
            return false;
        }
    }

    public static void b(Object obj) {
        Log.e("TPush-DataAcq", "" + obj);
    }
}
