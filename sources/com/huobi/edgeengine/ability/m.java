package com.huobi.edgeengine.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import rx.functions.Action1;

public final /* synthetic */ class m implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43926b;

    public /* synthetic */ m(AbilityFunction.a aVar) {
        this.f43926b = aVar;
    }

    public final void call(Object obj) {
        EngineHandleFavorite.q(this.f43926b, (Throwable) obj);
    }
}
