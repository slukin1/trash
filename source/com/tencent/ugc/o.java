package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50651a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50652b;

    private o(TXVideoEditer tXVideoEditer, List list) {
        this.f50651a = tXVideoEditer;
        this.f50652b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new o(tXVideoEditer, list);
    }

    public final void run() {
        TXVideoEditer.lambda$setSubtitleList$19(this.f50651a, this.f50652b);
    }
}
