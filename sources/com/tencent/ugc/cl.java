package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class cl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50290a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoJoiner.SplitScreenParam f50291b;

    private cl(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.SplitScreenParam splitScreenParam) {
        this.f50290a = tXVideoJoiner;
        this.f50291b = splitScreenParam;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.SplitScreenParam splitScreenParam) {
        return new cl(tXVideoJoiner, splitScreenParam);
    }

    public final void run() {
        TXVideoJoiner.lambda$setSplitScreenList$10(this.f50290a, this.f50291b);
    }
}
