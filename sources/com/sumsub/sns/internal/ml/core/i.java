package com.sumsub.sns.internal.ml.core;

import com.sumsub.sns.internal.ml.core.b;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class i implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f35027b;

    public /* synthetic */ i(b bVar) {
        this.f35027b = bVar;
    }

    public final Thread newThread(Runnable runnable) {
        return b.j.a(this.f35027b, runnable);
    }
}
