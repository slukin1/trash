package com.huobi.woodpecker.kalle;

import android.util.Log;
import bv.f;
import bv.i;

public final class Kalle {

    /* renamed from: a  reason: collision with root package name */
    public static g f21025a;

    public static class Download {
    }

    public static i.b a(Url url) {
        return i.n(url, RequestMethod.GET);
    }

    public static g b() {
        d((g) null);
        return f21025a;
    }

    public static f.b c(Url url) {
        return f.n(url, RequestMethod.POST);
    }

    public static void d(g gVar) {
        if (f21025a == null) {
            synchronized (g.class) {
                if (f21025a == null) {
                    if (gVar == null) {
                        gVar = g.q().r();
                    }
                    f21025a = gVar;
                } else {
                    Log.w("Kalle", new IllegalStateException("Only allowed to configure once."));
                }
            }
        }
    }
}
