package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class k implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final k f21510a = new k();

    private k() {
    }

    public static Callable a() {
        return f21510a;
    }

    public final Object call() {
        return Build.MANUFACTURER;
    }
}
