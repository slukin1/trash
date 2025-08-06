package com.xiaomi.push;

import android.content.Context;

public class cu {

    /* renamed from: a  reason: collision with root package name */
    private static cm f51534a;

    /* renamed from: a  reason: collision with other field name */
    private static cn f2630a;

    public static void a(Context context, fb fbVar) {
        if (b(context)) {
            if (f51534a == null) {
                f51534a = new cm(context);
            }
            if (f2630a == null) {
                f2630a = new cn(context);
            }
            cm cmVar = f51534a;
            fbVar.a((fg) cmVar, (fl) cmVar);
            cn cnVar = f2630a;
            fbVar.b((fg) cnVar, (fl) cnVar);
            a("startStats");
        }
    }

    public static void b(Context context, fb fbVar) {
        cm cmVar = f51534a;
        if (cmVar != null) {
            fbVar.a((fg) cmVar);
            f51534a = null;
        }
        cn cnVar = f2630a;
        if (cnVar != null) {
            fbVar.b((fg) cnVar);
            f2630a = null;
        }
        a("stopStats");
    }

    public static void c(Context context) {
        a("onPing");
        if (b(context)) {
            cx.c(context, System.currentTimeMillis(), a(context));
        }
    }

    public static void d(Context context) {
        a("onPong");
        if (b(context)) {
            cx.d(context, System.currentTimeMillis(), a(context));
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m2509b(Context context) {
        return cl.a(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (b(context)) {
            cx.a(context, System.currentTimeMillis(), a(context));
        }
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (b(context)) {
            cx.b(context, System.currentTimeMillis(), a(context));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2508a(Context context) {
        return i.b(context);
    }

    public static void a(String str) {
        cl.a("Push-PowerStats", str);
    }
}
