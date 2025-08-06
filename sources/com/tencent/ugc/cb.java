package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass3 f50266a;

    private cb(TXVideoEditer.AnonymousClass3 r12) {
        this.f50266a = r12;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass3 r12) {
        return new cb(r12);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass3.b(this.f50266a);
    }
}
