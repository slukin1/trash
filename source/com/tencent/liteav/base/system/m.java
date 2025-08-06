package com.tencent.liteav.base.system;

import android.os.Build;
import java.util.concurrent.Callable;

final /* synthetic */ class m implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final m f21512a = new m();

    private m() {
    }

    public static Callable a() {
        return f21512a;
    }

    public final Object call() {
        return Build.VERSION.RELEASE;
    }
}
