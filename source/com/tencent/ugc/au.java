package com.tencent.ugc;

final /* synthetic */ class au implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50163a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50164b;

    private au(TXVideoEditer tXVideoEditer, int i11) {
        this.f50163a = tXVideoEditer;
        this.f50164b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new au(tXVideoEditer, i11);
    }

    public final void run() {
        TXVideoEditer.lambda$setProfile$4(this.f50163a, this.f50164b);
    }
}
