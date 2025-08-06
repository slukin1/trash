package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8Function;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f43951b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ V8Function f43952c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f43953d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f43954e;

    public /* synthetic */ y(a0 a0Var, V8Function v8Function, boolean z11, Object obj) {
        this.f43951b = a0Var;
        this.f43952c = v8Function;
        this.f43953d = z11;
        this.f43954e = obj;
    }

    public final void run() {
        this.f43951b.o(this.f43952c, this.f43953d, this.f43954e);
    }
}
