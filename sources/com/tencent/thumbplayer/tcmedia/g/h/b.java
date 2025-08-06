package com.tencent.thumbplayer.tcmedia.g.h;

import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static int f49340a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49341b = true;

    /* renamed from: c  reason: collision with root package name */
    private static a f49342c = new a() {
        public final void d(String str, String str2) {
            Log.d(str, str2);
        }

        public final void e(String str, String str2, Throwable th2) {
            Log.e(str, str2, th2);
        }

        public final void i(String str, String str2) {
            Log.i(str, str2);
        }

        public final void v(String str, String str2) {
            Log.v(str, str2);
        }

        public final void w(String str, String str2, Throwable th2) {
            Log.w(str, str2, th2);
        }
    };

    public static void a(a aVar) {
        f49342c = aVar;
    }

    public static void a(String str, String str2) {
        if (a(2)) {
            f49342c.v("TMediaCodec.".concat(String.valueOf(str)), str2);
        }
    }

    public static void a(String str, String str2, Throwable th2) {
        if (a(5)) {
            f49342c.w("TMediaCodec.".concat(String.valueOf(str)), str2, th2);
        }
    }

    public static void a(boolean z11) {
        f49341b = z11;
    }

    public static boolean a() {
        return f49341b;
    }

    public static boolean a(int i11) {
        return f49341b && i11 >= f49340a;
    }

    public static void b(String str, String str2) {
        if (a(3)) {
            f49342c.d("TMediaCodec.".concat(String.valueOf(str)), str2);
        }
    }

    public static void b(String str, String str2, Throwable th2) {
        if (a(6)) {
            f49342c.e("TMediaCodec.".concat(String.valueOf(str)), str2, th2);
        }
    }

    public static void c(String str, String str2) {
        if (a(4)) {
            f49342c.i("TMediaCodec.".concat(String.valueOf(str)), str2);
        }
    }

    public static void d(String str, String str2) {
        if (a(5)) {
            f49342c.w("TMediaCodec.".concat(String.valueOf(str)), str2, (Throwable) null);
        }
    }

    public static void e(String str, String str2) {
        if (a(6)) {
            f49342c.e("TMediaCodec.".concat(String.valueOf(str)), str2, (Throwable) null);
        }
    }
}
