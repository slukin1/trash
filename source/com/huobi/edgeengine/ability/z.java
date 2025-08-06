package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8Function;
import rj.b;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f43955b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s f43956c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f43957d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f43958e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ V8Function f43959f;

    public /* synthetic */ z(a0 a0Var, s sVar, b bVar, Object obj, V8Function v8Function) {
        this.f43955b = a0Var;
        this.f43956c = sVar;
        this.f43957d = bVar;
        this.f43958e = obj;
        this.f43959f = v8Function;
    }

    public final void run() {
        this.f43955b.r(this.f43956c, this.f43957d, this.f43958e, this.f43959f);
    }
}
