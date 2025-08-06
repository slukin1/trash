package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.d;

final class x implements Runnable {
    public final /* synthetic */ d bP;
    public final /* synthetic */ boolean bR;

    /* renamed from: ba  reason: collision with root package name */
    public final /* synthetic */ boolean f51103ba;

    /* renamed from: cg  reason: collision with root package name */
    public final /* synthetic */ t f51104cg;

    /* renamed from: ck  reason: collision with root package name */
    public final /* synthetic */ aj f51105ck;

    public x(t tVar, d dVar, aj ajVar, boolean z11, boolean z12) {
        this.f51104cg = tVar;
        this.bP = dVar;
        this.f51105ck = ajVar;
        this.bR = z11;
        this.f51103ba = z12;
    }

    public final void run() {
        this.f51104cg.a(this.bP, this.f51105ck, this.bR, this.f51103ba);
    }
}
