package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50749a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50750b;

    private q(TXVideoEditer tXVideoEditer, List list) {
        this.f50749a = tXVideoEditer;
        this.f50750b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new q(tXVideoEditer, list);
    }

    public final void run() {
        TXVideoEditer.lambda$setPasterList$21(this.f50749a, this.f50750b);
    }
}
