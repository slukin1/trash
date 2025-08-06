package com.huobi.finance.presenter;

import com.huobi.finance.bean.MarginBalanceDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class x1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46170b;

    public /* synthetic */ x1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46170b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46170b.u2((MarginBalanceDataTotal) obj);
    }
}
