package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50653a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50654b;

    private p(TXVideoEditer tXVideoEditer, List list) {
        this.f50653a = tXVideoEditer;
        this.f50654b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new p(tXVideoEditer, list);
    }

    public final void run() {
        TXVideoEditer.lambda$setAnimatedPasterList$20(this.f50653a, this.f50654b);
    }
}
