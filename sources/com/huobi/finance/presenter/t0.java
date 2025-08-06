package com.huobi.finance.presenter;

import com.huobi.finance.bean.BalanceDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class t0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46113b;

    public /* synthetic */ t0(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46113b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46113b.y2((BalanceDataTotal) obj);
    }
}
