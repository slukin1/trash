package com.huobi.index.presenter;

import com.huobi.contract.entity.ContractHeartBeat;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureRankPresenter f73450b;

    public /* synthetic */ j(FutureRankPresenter futureRankPresenter) {
        this.f73450b = futureRankPresenter;
    }

    public final void call(Object obj) {
        this.f73450b.n((ContractHeartBeat) obj);
    }
}
