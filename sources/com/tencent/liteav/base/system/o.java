package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class o implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final o f21514a = new o();

    private o() {
    }

    public static Callable a() {
        return f21514a;
    }

    public final Object call() {
        return Build.BOARD;
    }
}
