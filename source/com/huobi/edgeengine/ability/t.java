package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f43935b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ V8Function f43936c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ V8Object f43937d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f43938e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f43939f;

    public /* synthetic */ t(u uVar, V8Function v8Function, V8Object v8Object, int i11, int i12) {
        this.f43935b = uVar;
        this.f43936c = v8Function;
        this.f43937d = v8Object;
        this.f43938e = i11;
        this.f43939f = i12;
    }

    public final void run() {
        this.f43935b.d(this.f43936c, this.f43937d, this.f43938e, this.f43939f);
    }
}
