package com.huobi.edgeengine.ability;

import com.huobi.edgeengine.ability.AbilityFunction;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43925b;

    public /* synthetic */ l(AbilityFunction.a aVar) {
        this.f43925b = aVar;
    }

    public final void call(Object obj) {
        EngineHandleFavorite.l(this.f43925b, (Throwable) obj);
    }
}
