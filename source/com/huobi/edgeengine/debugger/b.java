package com.huobi.edgeengine.debugger;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Debugger f43999b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44000c;

    public /* synthetic */ b(Debugger debugger, String str) {
        this.f43999b = debugger;
        this.f44000c = str;
    }

    public final void run() {
        Debugger$onDisconnect$1.m2306invoke$lambda1$lambda0(this.f43999b, this.f44000c);
    }
}
