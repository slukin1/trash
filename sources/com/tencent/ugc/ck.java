package com.tencent.ugc;

final /* synthetic */ class ck implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50289a;

    private ck(TXVideoJoiner tXVideoJoiner) {
        this.f50289a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new ck(tXVideoJoiner);
    }

    public final void run() {
        TXVideoJoiner.lambda$cancel$9(this.f50289a);
    }
}
