package com.huobi.edgeengine.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import rj.b;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f43929b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43930c;

    public /* synthetic */ o(b bVar, AbilityFunction.a aVar) {
        this.f43929b = bVar;
        this.f43930c = aVar;
    }

    public final void call(Object obj) {
        EngineHandleFavorite.o(this.f43929b, this.f43930c, obj);
    }
}
