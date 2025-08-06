package com.tencent.ugc;

final /* synthetic */ class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50299a;

    private cp(TXVideoJoiner tXVideoJoiner) {
        this.f50299a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new cp(tXVideoJoiner);
    }

    public final void run() {
        TXVideoJoiner.lambda$notifyJoinComplete$14(this.f50299a);
    }
}
