package com.tencent.ugc;

final /* synthetic */ class bw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50256a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50257b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50258c;

    private bw(TXVideoEditer tXVideoEditer, int i11, int i12) {
        this.f50256a = tXVideoEditer;
        this.f50257b = i11;
        this.f50258c = i12;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, int i12) {
        return new bw(tXVideoEditer, i11, i12);
    }

    public final void run() {
        TXVideoEditer.lambda$setBeautyFilter$8(this.f50256a, this.f50257b, this.f50258c);
    }
}
