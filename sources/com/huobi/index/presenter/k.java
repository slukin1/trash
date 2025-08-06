package com.huobi.index.presenter;

import com.huobi.contract.entity.ContractHeartBeat;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureRankPresenter f73452b;

    public /* synthetic */ k(FutureRankPresenter futureRankPresenter) {
        this.f73452b = futureRankPresenter;
    }

    public final void call(Object obj) {
        this.f73452b.o((ContractHeartBeat) obj);
    }
}
