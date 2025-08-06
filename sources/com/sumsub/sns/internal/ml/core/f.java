package com.sumsub.sns.internal.ml.core;

import com.sumsub.sns.internal.ml.core.b;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class f implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f35023b;

    public /* synthetic */ f(b bVar) {
        this.f35023b = bVar;
    }

    public final Thread newThread(Runnable runnable) {
        return b.c.a(this.f35023b, runnable);
    }
}
