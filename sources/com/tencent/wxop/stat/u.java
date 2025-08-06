package com.tencent.wxop.stat;

import java.util.List;

final class u implements Runnable {
    public final /* synthetic */ boolean bR;

    /* renamed from: ba  reason: collision with root package name */
    public final /* synthetic */ boolean f51095ba;

    /* renamed from: bc  reason: collision with root package name */
    public final /* synthetic */ List f51096bc;

    /* renamed from: cg  reason: collision with root package name */
    public final /* synthetic */ t f51097cg;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f51098g = 1;

    public u(t tVar, List list, boolean z11) {
        this.f51097cg = tVar;
        this.f51096bc = list;
        this.bR = z11;
        this.f51095ba = true;
    }

    public final void run() {
        this.f51097cg.a((List<ad>) this.f51096bc, this.f51098g, this.bR);
        if (this.f51095ba) {
            this.f51096bc.clear();
        }
    }
}
