package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class bz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass2 f50262a;

    private bz(TXVideoEditer.AnonymousClass2 r12) {
        this.f50262a = r12;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass2 r12) {
        return new bz(r12);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass2.a(this.f50262a);
    }
}
