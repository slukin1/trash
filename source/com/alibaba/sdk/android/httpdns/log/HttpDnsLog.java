package com.alibaba.sdk.android.httpdns.log;

import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import m2.d;

public class HttpDnsLog {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14661a = false;

    /* renamed from: b  reason: collision with root package name */
    public static HashSet<d> f14662b = new HashSet<>();

    public static void a(Throwable th2) {
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log(Log.getStackTraceString(th2));
            }
        }
    }

    public static void b(String str) {
        if (f14661a) {
            Log.d("httpdns", str);
        }
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log("[D]" + str);
            }
        }
    }

    public static void c(String str) {
        if (f14661a) {
            Log.e("httpdns", str);
        }
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log("[E]" + str);
            }
        }
    }

    public static void d(String str, Throwable th2) {
        if (f14661a) {
            Log.e("httpdns", str, th2);
        }
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log("[E]" + str);
            }
            a(th2);
        }
    }

    public static void e(boolean z11) {
        f14661a = z11;
    }

    public static boolean f() {
        return f14661a;
    }

    public static void g(String str) {
        if (f14661a) {
            Log.i("httpdns", str);
        }
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log("[I]" + str);
            }
        }
    }

    public static void h(d dVar) {
        if (dVar != null) {
            f14662b.add(dVar);
        }
    }

    public static void i(String str) {
        if (f14661a) {
            Log.w("httpdns", str);
        }
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log("[W]" + str);
            }
        }
    }

    public static void j(String str, Throwable th2) {
        if (f14661a) {
            Log.e("httpdns", str, th2);
        }
        if (f14662b.size() > 0) {
            Iterator<d> it2 = f14662b.iterator();
            while (it2.hasNext()) {
                it2.next().log("[W]" + str);
            }
            a(th2);
        }
    }
}
