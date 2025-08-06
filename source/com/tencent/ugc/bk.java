package com.tencent.ugc;

final /* synthetic */ class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50222a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50223b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50224c;

    private bk(TXVideoEditer tXVideoEditer, int i11, long j11) {
        this.f50222a = tXVideoEditer;
        this.f50223b = i11;
        this.f50224c = j11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, long j11) {
        return new bk(tXVideoEditer, i11, j11);
    }

    public final void run() {
        TXVideoEditer.lambda$handleWriteMP4Completed$64(this.f50222a, this.f50223b, this.f50224c);
    }
}
