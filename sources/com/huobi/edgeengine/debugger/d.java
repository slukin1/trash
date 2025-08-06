package com.huobi.edgeengine.debugger;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Debugger f44003b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SetBreakpointByUrlRequest f44004c;

    public /* synthetic */ d(Debugger debugger, SetBreakpointByUrlRequest setBreakpointByUrlRequest) {
        this.f44003b = debugger;
        this.f44004c = setBreakpointByUrlRequest;
    }

    public final void run() {
        Debugger$setBreakpointByUrl$1.m2308invoke$lambda0(this.f44003b, this.f44004c);
    }
}
