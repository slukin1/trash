package com.tencent.ugc;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50497a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50498b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50499c;

    private f(TXVideoEditer tXVideoEditer, String str, boolean z11) {
        this.f50497a = tXVideoEditer;
        this.f50498b = str;
        this.f50499c = z11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, String str, boolean z11) {
        return new f(tXVideoEditer, str, z11);
    }

    public final void run() {
        TXVideoEditer.lambda$setBGM$11(this.f50497a, this.f50498b, this.f50499c);
    }
}
