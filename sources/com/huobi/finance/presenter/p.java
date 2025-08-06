package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcOptionDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class p implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46049b;

    public /* synthetic */ p(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46049b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46049b.n2((OtcOptionDataTotal) obj);
    }
}
