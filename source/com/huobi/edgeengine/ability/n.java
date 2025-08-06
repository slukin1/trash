package com.huobi.edgeengine.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f43927b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43928c;

    public /* synthetic */ n(b bVar, AbilityFunction.a aVar) {
        this.f43927b = bVar;
        this.f43928c = aVar;
    }

    public final void call(Object obj) {
        EngineHandleFavorite.j(this.f43927b, this.f43928c, obj);
    }
}
