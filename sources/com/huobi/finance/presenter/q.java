package com.huobi.finance.presenter;

import com.huobi.finance.bean.SavingsDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46066b;

    public /* synthetic */ q(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46066b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46066b.s2((SavingsDataTotal) obj);
    }
}
