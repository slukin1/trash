package com.tencent.ugc;

final /* synthetic */ class ct implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50305a;

    private ct(TXVideoJoiner tXVideoJoiner) {
        this.f50305a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new ct(tXVideoJoiner);
    }

    public final void run() {
        TXVideoJoiner.lambda$pausePlay$4(this.f50305a);
    }
}
