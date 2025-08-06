package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class i implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final i f21508a = new i();

    private i() {
    }

    public static Callable a() {
        return f21508a;
    }

    public final Object call() {
        return Build.MODEL;
    }
}
