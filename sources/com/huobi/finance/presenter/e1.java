package com.huobi.finance.presenter;

import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class e1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f45859b;

    public /* synthetic */ e1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f45859b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f45859b.w2((C2CLendBalanceDataTotal) obj);
    }
}
