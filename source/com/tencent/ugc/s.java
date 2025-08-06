package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50816a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50817b;

    private s(TXVideoEditer tXVideoEditer, List list) {
        this.f50816a = tXVideoEditer;
        this.f50817b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new s(tXVideoEditer, list);
    }

    public final void run() {
        TXVideoEditer.lambda$setSpeedList$23(this.f50816a, this.f50817b);
    }
}
