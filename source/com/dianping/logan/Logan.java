package com.dianping.logan;

public class Logan {

    /* renamed from: a  reason: collision with root package name */
    public static e f64822a = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f64823b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f64824c = false;

    public static void a(LoganConfig loganConfig) {
        f64823b = a.c(loganConfig);
    }

    public static void b(String str, int i11) {
        e eVar = f64822a;
        if (eVar != null) {
            eVar.a(str, i11);
        }
    }

    public static void c(String[] strArr, SendLogRunnable sendLogRunnable) {
        a aVar = f64823b;
        if (aVar != null) {
            aVar.d(strArr, sendLogRunnable);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }

    public static void d(boolean z11) {
        f64824c = z11;
    }

    public static void e(String str, int i11) {
        a aVar = f64823b;
        if (aVar != null) {
            aVar.e(str, i11);
            return;
        }
        throw new RuntimeException("Please initialize Logan first");
    }
}
