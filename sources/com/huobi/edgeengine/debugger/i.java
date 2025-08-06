package com.huobi.edgeengine.debugger;

import com.huobi.edgeengine.debugger.j;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j.a f44012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f44013c;

    public /* synthetic */ i(j.a aVar, Throwable th2) {
        this.f44012b = aVar;
        this.f44013c = th2;
    }

    public final void run() {
        j.a.d(this.f44012b, this.f44013c);
    }
}
