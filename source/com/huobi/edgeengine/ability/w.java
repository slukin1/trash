package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8Function;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public final /* synthetic */ class w implements AbilityFunction.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f43945a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f43946b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ V8Function f43947c;

    public /* synthetic */ w(a0 a0Var, b bVar, V8Function v8Function) {
        this.f43945a = a0Var;
        this.f43946b = bVar;
        this.f43947c = v8Function;
    }

    public final void a(boolean z11, Object obj) {
        this.f43945a.p(this.f43946b, this.f43947c, z11, obj);
    }
}
