package com.sumsub.sentry;

import kotlin.jvm.internal.r;

public final class i extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    public final o f30378a;

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f30379b;

    /* renamed from: c  reason: collision with root package name */
    public final Thread f30380c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f30381d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(o oVar, Throwable th2, Thread thread, boolean z11, int i11, r rVar) {
        this(oVar, th2, thread, (i11 & 8) != 0 ? false : z11);
    }

    public final o a() {
        return this.f30378a;
    }

    public final Thread b() {
        return this.f30380c;
    }

    public final Throwable c() {
        return this.f30379b;
    }

    public final boolean d() {
        return this.f30381d;
    }

    public i(o oVar, Throwable th2, Thread thread, boolean z11) {
        this.f30378a = oVar;
        this.f30379b = th2;
        this.f30380c = thread;
        this.f30381d = z11;
    }
}
