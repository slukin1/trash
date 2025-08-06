package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class n implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final n f21513a = new n();

    private n() {
    }

    public static Callable a() {
        return f21513a;
    }

    public final Object call() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
