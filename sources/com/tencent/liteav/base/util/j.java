package com.tencent.liteav.base.util;

import com.tencent.liteav.base.ContextUtils;
import java.util.concurrent.Callable;

final /* synthetic */ class j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final j f21543a = new j();

    private j() {
    }

    public static Callable a() {
        return f21543a;
    }

    public final Object call() {
        return Boolean.valueOf(i.a(ContextUtils.getApplicationContext()));
    }
}
