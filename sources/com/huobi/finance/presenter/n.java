package com.huobi.finance.presenter;

import com.huobi.finance.bean.MineDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46007b;

    public /* synthetic */ n(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46007b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46007b.t2((MineDataTotal) obj);
    }
}
