package com.tencent.ugc;

final /* synthetic */ class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50304a;

    private cs(TXVideoJoiner tXVideoJoiner) {
        this.f50304a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new cs(tXVideoJoiner);
    }

    public final void run() {
        TXVideoJoiner.lambda$startPlay$3(this.f50304a);
    }
}
