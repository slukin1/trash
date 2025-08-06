package com.huobi.edgeengine.ability;

import com.eclipsesource.v8.V8Function;
import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;

public final /* synthetic */ class x implements AbilityFunction.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f43948a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f43949b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ V8Function f43950c;

    public /* synthetic */ x(a0 a0Var, b bVar, V8Function v8Function) {
        this.f43948a = a0Var;
        this.f43949b = bVar;
        this.f43950c = v8Function;
    }

    public final void a(boolean z11, Object obj) {
        this.f43948a.n(this.f43949b, this.f43950c, z11, obj);
    }
}
