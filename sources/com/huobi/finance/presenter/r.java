package com.huobi.finance.presenter;

import com.huobi.finance.bean.SuperMarginDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class r implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46082b;

    public /* synthetic */ r(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46082b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46082b.x2((SuperMarginDataTotal) obj);
    }
}
