package com.tencent.liteav.base.util;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class m implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f21558a;

    private m(String str) {
        this.f21558a = str;
    }

    public static ThreadFactory a(String str) {
        return new m(str);
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f21558a);
    }
}
