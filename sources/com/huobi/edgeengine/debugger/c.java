package com.huobi.edgeengine.debugger;

import org.json.JSONObject;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Debugger f44001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JSONObject f44002c;

    public /* synthetic */ c(Debugger debugger, JSONObject jSONObject) {
        this.f44001b = debugger;
        this.f44002c = jSONObject;
    }

    public final void run() {
        Debugger$removeBreakpoint$1.m2307invoke$lambda0(this.f44001b, this.f44002c);
    }
}
