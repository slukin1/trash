package com.tencent.wxop.stat;

final class ab implements Runnable {
    public final /* synthetic */ int aI;

    /* renamed from: cl  reason: collision with root package name */
    public final /* synthetic */ t f50956cl;

    public ab(t tVar, int i11) {
        this.f50956cl = tVar;
        this.aI = i11;
    }

    public final void run() {
        t.a(this.f50956cl, this.aI, true);
        t.a(this.f50956cl, this.aI, false);
    }
}
