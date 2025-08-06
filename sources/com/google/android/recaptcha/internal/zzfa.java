package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.Map;
import kotlin.l;

public final class zzfa {
    public static final zzfa zza = new zzfa();

    private zzfa() {
    }

    public static final Map zza() {
        Map m11 = MapsKt__MapsKt.m(l.a(-4, zzl.zzz), l.a(-12, zzl.zzA), l.a(-6, zzl.zzv), l.a(-11, zzl.zzx), l.a(-13, zzl.zzB), l.a(-14, zzl.zzC), l.a(-2, zzl.zzw), l.a(-7, zzl.zzD), l.a(-5, zzl.zzE), l.a(-9, zzl.zzF), l.a(-8, zzl.zzP), l.a(-15, zzl.zzy), l.a(-1, zzl.zzG), l.a(-3, zzl.zzI), l.a(-10, zzl.zzJ));
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            m11.put(-16, zzl.zzH);
        }
        if (i11 >= 27) {
            m11.put(1, zzl.zzL);
            m11.put(2, zzl.zzM);
            m11.put(0, zzl.zzN);
            m11.put(3, zzl.zzO);
        }
        if (i11 >= 29) {
            m11.put(4, zzl.zzK);
        }
        return m11;
    }
}
