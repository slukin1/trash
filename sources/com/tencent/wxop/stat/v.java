package com.tencent.wxop.stat;

import java.util.List;

final class v implements Runnable {
    public final /* synthetic */ boolean bR = true;

    /* renamed from: bc  reason: collision with root package name */
    public final /* synthetic */ List f51099bc;

    /* renamed from: ch  reason: collision with root package name */
    public final /* synthetic */ boolean f51100ch;

    /* renamed from: ci  reason: collision with root package name */
    public final /* synthetic */ t f51101ci;

    public v(t tVar, List list, boolean z11) {
        this.f51101ci = tVar;
        this.f51099bc = list;
        this.f51100ch = z11;
    }

    public final void run() {
        this.f51101ci.a((List<ad>) this.f51099bc, this.f51100ch);
        if (this.bR) {
            this.f51099bc.clear();
        }
    }
}
