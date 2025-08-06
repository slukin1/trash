package com.huobi.finance.presenter;

import com.huobi.finance.bean.LinearSwapDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class w1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46157b;

    public /* synthetic */ w1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46157b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46157b.q2((LinearSwapDataTotal) obj);
    }
}
