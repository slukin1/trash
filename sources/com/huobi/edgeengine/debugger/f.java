package com.huobi.edgeengine.debugger;

import org.json.JSONObject;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Debugger f44007b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JSONObject f44008c;

    public /* synthetic */ f(Debugger debugger, JSONObject jSONObject) {
        this.f44007b = debugger;
        this.f44008c = jSONObject;
    }

    public final void run() {
        Debugger$setScriptSource$1.m2310invoke$lambda0(this.f44007b, this.f44008c);
    }
}
