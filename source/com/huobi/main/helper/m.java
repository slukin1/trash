package com.huobi.main.helper;

import com.hbg.lib.core.util.n;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f77746a;

    public static m b() {
        if (f77746a == null) {
            synchronized (m.class) {
                if (f77746a == null) {
                    f77746a = new m();
                }
            }
        }
        return f77746a;
    }

    public void a() {
        n.o().m();
    }
}
