package com.tencent.ugc;

import java.util.concurrent.atomic.AtomicBoolean;

final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50822a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50823b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50824c;

    /* renamed from: d  reason: collision with root package name */
    private final long f50825d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f50826e;

    private v(TXVideoEditer tXVideoEditer, int i11, long j11, long j12, AtomicBoolean atomicBoolean) {
        this.f50822a = tXVideoEditer;
        this.f50823b = i11;
        this.f50824c = j11;
        this.f50825d = j12;
        this.f50826e = atomicBoolean;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, long j11, long j12, AtomicBoolean atomicBoolean) {
        return new v(tXVideoEditer, i11, j11, j12, atomicBoolean);
    }

    public final void run() {
        TXVideoEditer.lambda$setTransitionEffect$26(this.f50822a, this.f50823b, this.f50824c, this.f50825d, this.f50826e);
    }
}
