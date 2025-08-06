package com.tencent.liteav.base.util;

import android.text.TextUtils;
import android.util.Log;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f21566a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f21567b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f21568c = "";

    public static boolean a() {
        boolean z11;
        synchronized (f21566a) {
            if (!f21567b) {
                Log.w("SoLoader", "load library txsoundtouch ".concat(String.valueOf(a("txsoundtouch"))));
                Log.w("SoLoader", "load library txffmpeg ".concat(String.valueOf(a("txffmpeg"))));
                f21567b = a("liteavsdk");
                Log.w("SoLoader", "load library liteavsdk " + f21567b);
            }
            z11 = f21567b;
        }
        return z11;
    }

    public static String b() {
        return f21568c;
    }

    public static void b(String str) {
        Log.w("SoLoader", "setLibraryPath ".concat(String.valueOf(str)));
        f21568c = str;
    }

    public static boolean a(String str) {
        try {
            if (!TextUtils.isEmpty(f21568c) ? a(f21568c, str) : false) {
                return true;
            }
            Log.w("SoLoader", "load library " + str + " from system path ");
            System.loadLibrary(str);
            return true;
        } catch (Error e11) {
            Log.w("SoLoader", "load library : " + e11.toString());
            return false;
        } catch (Exception e12) {
            Log.w("SoLoader", "load library : " + e12.toString());
            return false;
        }
    }

    private static boolean a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Log.w("SoLoader", "load library " + str2 + " from path " + str);
            System.load(str + "/lib" + str2 + ".so");
            return true;
        } catch (Error e11) {
            Log.w("SoLoader", "load library : " + e11.toString());
            return false;
        } catch (Exception e12) {
            Log.w("SoLoader", "load library : " + e12.toString());
            return false;
        }
    }
}
