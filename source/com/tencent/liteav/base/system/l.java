package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class l implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final l f21511a = new l();

    private l() {
    }

    public static Callable a() {
        return f21511a;
    }

    public final Object call() {
        return Build.HARDWARE;
    }
}
