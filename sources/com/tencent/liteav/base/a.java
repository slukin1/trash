package com.tencent.liteav.base;

import java.util.concurrent.Callable;

final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private static final a f21398a = new a();

    private a() {
    }

    public static Callable a() {
        return f21398a;
    }

    public final Object call() {
        return PathUtils.setPrivateDataDirectorySuffixInternal();
    }
}
