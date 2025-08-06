package com.huobi.edgeengine.debugger;

import org.json.JSONObject;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Debugger f44005b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JSONObject f44006c;

    public /* synthetic */ e(Debugger debugger, JSONObject jSONObject) {
        this.f44005b = debugger;
        this.f44006c = jSONObject;
    }

    public final void run() {
        Debugger$setBreakpointsActive$1.m2309invoke$lambda0(this.f44005b, this.f44006c);
    }
}
