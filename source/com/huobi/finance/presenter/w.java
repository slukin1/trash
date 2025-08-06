package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f46155c;

    public /* synthetic */ w(BalanceAssetPresenter balanceAssetPresenter, int i11) {
        this.f46154b = balanceAssetPresenter;
        this.f46155c = i11;
    }

    public final void call(Object obj) {
        this.f46154b.X2(this.f46155c, (Boolean) obj);
    }
}
