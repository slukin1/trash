package com.tencent.ugc;

final /* synthetic */ class ax implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50170a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50171b;

    private ax(TXVideoEditer tXVideoEditer, int i11) {
        this.f50170a = tXVideoEditer;
        this.f50171b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new ax(tXVideoEditer, i11);
    }

    public final void run() {
        TXVideoEditer.lambda$setVideoBitrate$52(this.f50170a, this.f50171b);
    }
}
