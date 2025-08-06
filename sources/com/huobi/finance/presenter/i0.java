package com.huobi.finance.presenter;

import com.huobi.contract.entity.ContractHeartBeat;
import rx.functions.Action1;

public final /* synthetic */ class i0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f45916b;

    public /* synthetic */ i0(BalanceAssetPresenter balanceAssetPresenter) {
        this.f45916b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f45916b.A3((ContractHeartBeat) obj);
    }
}
