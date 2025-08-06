package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass3 f50269a;

    private cd(TXVideoEditer.AnonymousClass3 r12) {
        this.f50269a = r12;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass3 r12) {
        return new cd(r12);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass3.a(this.f50269a);
    }
}
