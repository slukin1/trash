package com.tencent.ugc;

final /* synthetic */ class cu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50306a;

    private cu(TXVideoJoiner tXVideoJoiner) {
        this.f50306a = tXVideoJoiner;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner) {
        return new cu(tXVideoJoiner);
    }

    public final void run() {
        TXVideoJoiner.lambda$resumePlay$5(this.f50306a);
    }
}
