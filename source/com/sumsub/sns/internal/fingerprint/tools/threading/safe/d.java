package com.sumsub.sns.internal.fingerprint.tools.threading.safe;

import d10.a;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f34680b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f34681c;

    public /* synthetic */ d(AtomicReference atomicReference, a aVar) {
        this.f34680b = atomicReference;
        this.f34681c = aVar;
    }

    public final Object call() {
        return c.a(this.f34680b, this.f34681c);
    }
}
