package com.huobi.finance.presenter;

import com.huobi.finance.bean.LegalDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class v1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46143b;

    public /* synthetic */ v1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46143b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46143b.z2((LegalDataTotal) obj);
    }
}
