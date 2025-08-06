package com.huobi.finance.presenter;

import com.huobi.finance.bean.ContractDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class u1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46129b;

    public /* synthetic */ u1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46129b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46129b.r2((ContractDataTotal) obj);
    }
}
