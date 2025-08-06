package com.huobi.finance.presenter;

import com.huobi.finance.bean.OptionDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46030b;

    public /* synthetic */ o(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46030b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46030b.p2((OptionDataTotal) obj);
    }
}
