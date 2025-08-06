package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final j f21509a = new j();

    private j() {
    }

    public static Callable a() {
        return f21509a;
    }

    public final Object call() {
        return Build.BRAND;
    }
}
