package com.huobi.finance.presenter;

import com.huobi.finance.bean.C2CMarginBalanceDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class p1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46051b;

    public /* synthetic */ p1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46051b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46051b.v2((C2CMarginBalanceDataTotal) obj);
    }
}
