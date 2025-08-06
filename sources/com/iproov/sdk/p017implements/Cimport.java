package com.iproov.sdk.p017implements;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;

/* renamed from: com.iproov.sdk.implements.import  reason: invalid class name and invalid package */
public class Cimport {

    /* renamed from: do  reason: not valid java name */
    private static final Handler f941do = new Handler(Looper.getMainLooper());

    /* renamed from: do  reason: not valid java name */
    public static int m1013do(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i13, i11));
    }

    /* renamed from: do  reason: not valid java name */
    public static <T> T m1015do(T t11, T t12) {
        return t11 != null ? t11 : t12;
    }

    /* renamed from: if  reason: not valid java name */
    public static String m1019if(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static double m1012do(double d11, double d12, double d13) {
        return Math.max(d12, Math.min(d13, d11));
    }

    /* renamed from: do  reason: not valid java name */
    public static void m1017do(Runnable runnable) {
        f941do.post(runnable);
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m1018do(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: do  reason: not valid java name */
    public static String m1016do(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    /* renamed from: do  reason: not valid java name */
    public static int m1014do(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
