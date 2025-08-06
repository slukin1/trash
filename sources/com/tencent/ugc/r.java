package com.tencent.ugc;

final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50751a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50752b;

    private r(TXVideoEditer tXVideoEditer, int i11) {
        this.f50751a = tXVideoEditer;
        this.f50752b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new r(tXVideoEditer, i11);
    }

    public final void run() {
        TXVideoEditer.lambda$setRenderRotation$22(this.f50751a, this.f50752b);
    }
}
