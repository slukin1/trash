package com.huobi.edgeengine.ability;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.edgeengine.ability.AbilityFunction;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43924b;

    public /* synthetic */ k(AbilityFunction.a aVar) {
        this.f43924b = aVar;
    }

    public final void call(Object obj) {
        EngineHandleFavorite.p(this.f43924b, (APIStatusErrorException) obj);
    }
}
