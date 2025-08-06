package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class ce implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass4 f50270a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50271b;

    private ce(TXVideoEditer.AnonymousClass4 r12, long j11) {
        this.f50270a = r12;
        this.f50271b = j11;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass4 r12, long j11) {
        return new ce(r12, j11);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass4.a(this.f50270a, this.f50271b);
    }
}
