package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

public final class a {
    /* access modifiers changed from: private */
    public static int level = 6;

    /* renamed from: q  reason: collision with root package name */
    public static d f22731q;

    /* renamed from: r  reason: collision with root package name */
    private static C0181a f22732r;

    /* renamed from: s  reason: collision with root package name */
    private static C0181a f22733s;

    /* renamed from: t  reason: collision with root package name */
    private static final String f22734t;

    /* renamed from: com.tencent.mm.sdk.b.a$a  reason: collision with other inner class name */
    public interface C0181a {
        void e(String str, String str2);

        void f(String str, String str2);

        void g(String str, String str2);

        int h();

        void h(String str, String str2);
    }

    static {
        b bVar = new b();
        f22732r = bVar;
        f22733s = bVar;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
        sb2.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
        sb2.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
        sb2.append("] BOARD:[" + Build.BOARD);
        sb2.append("] DEVICE:[" + Build.DEVICE);
        sb2.append("] DISPLAY:[" + Build.DISPLAY);
        sb2.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        sb2.append("] HOST:[" + Build.HOST);
        sb2.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        sb2.append("] MODEL:[" + Build.MODEL);
        sb2.append("] PRODUCT:[" + Build.PRODUCT);
        sb2.append("] TAGS:[" + Build.TAGS);
        sb2.append("] TYPE:[" + Build.TYPE);
        sb2.append("] USER:[" + Build.USER + "]");
        f22734t = sb2.toString();
    }

    public static void a(String str, String str2) {
        a(str, str2, (Object[]) null);
    }

    public static void a(String str, String str2, Object... objArr) {
        C0181a aVar = f22733s;
        if (aVar != null && aVar.h() <= 4) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String i11 = i(str);
            C0181a aVar2 = f22733s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.h(i11, str2);
        }
    }

    public static void b(String str, String str2) {
        C0181a aVar = f22733s;
        if (aVar != null && aVar.h() <= 3) {
            if (str2 == null) {
                str2 = "";
            }
            String i11 = i(str);
            C0181a aVar2 = f22733s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.g(i11, str2);
        }
    }

    public static void c(String str, String str2) {
        C0181a aVar = f22733s;
        if (aVar != null && aVar.h() <= 2) {
            if (str2 == null) {
                str2 = "";
            }
            String i11 = i(str);
            C0181a aVar2 = f22733s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.e(i11, str2);
        }
    }

    public static void d(String str, String str2) {
        C0181a aVar = f22733s;
        if (aVar != null && aVar.h() <= 1) {
            if (str2 == null) {
                str2 = "";
            }
            String i11 = i(str);
            C0181a aVar2 = f22733s;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar2.f(i11, str2);
        }
    }

    private static String i(String str) {
        d dVar = f22731q;
        return dVar != null ? dVar.i(str) : str;
    }
}
