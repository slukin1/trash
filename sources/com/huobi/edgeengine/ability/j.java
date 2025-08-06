package com.huobi.edgeengine.ability;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.edgeengine.ability.AbilityFunction;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbilityFunction.a f43923b;

    public /* synthetic */ j(AbilityFunction.a aVar) {
        this.f43923b = aVar;
    }

    public final void call(Object obj) {
        EngineHandleFavorite.k(this.f43923b, (APIStatusErrorException) obj);
    }
}
