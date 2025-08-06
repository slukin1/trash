package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

final /* synthetic */ class f implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final f f21505a = new f();

    private f() {
    }

    public static Callable a() {
        return f21505a;
    }

    public final Object call() {
        return a.c();
    }
}
