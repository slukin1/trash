package com.huobi.kalle;

import android.util.Log;
import lm.f;

public final class Kalle {

    /* renamed from: a  reason: collision with root package name */
    public static g f74667a;

    public static class Download {
    }

    public static g a() {
        d((g) null);
        return f74667a;
    }

    public static f.b b(Url url) {
        return f.n(url, RequestMethod.POST);
    }

    public static f.b c(String str) {
        return f.n(Url.j(str).i(), RequestMethod.POST);
    }

    public static void d(g gVar) {
        if (f74667a == null) {
            synchronized (g.class) {
                if (f74667a == null) {
                    if (gVar == null) {
                        gVar = g.q().r();
                    }
                    f74667a = gVar;
                } else {
                    Log.w("Kalle", new IllegalStateException("Only allowed to configure once."));
                }
            }
        }
    }
}
