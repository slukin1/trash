package com.tencent.ugc;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50395a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50396b;

    private e(TXVideoEditer tXVideoEditer, int i11) {
        this.f50395a = tXVideoEditer;
        this.f50396b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new e(tXVideoEditer, i11);
    }

    public final void run() {
        TXVideoEditer.lambda$setPictureTransition$10(this.f50395a, this.f50396b);
    }
}
