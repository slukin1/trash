package com.huobi.finance.utils;

import android.os.Build;

public final class AssetAnimHelper {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47437a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47438b = (Build.VERSION.SDK_INT > 22);

    public static boolean a() {
        return f47437a;
    }

    public static boolean b() {
        return f47438b;
    }

    public static void c(boolean z11) {
        f47437a = z11;
    }
}
