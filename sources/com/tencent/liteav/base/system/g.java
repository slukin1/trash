package com.tencent.liteav.base.system;

import java.util.concurrent.Callable;

final /* synthetic */ class g implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final g f21506a = new g();

    private g() {
    }

    public static Callable a() {
        return f21506a;
    }

    public final Object call() {
        return p.a(LiteavSystemInfo.sAppPackageName.a());
    }
}
