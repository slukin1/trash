package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class v implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46140b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f46141c;

    public /* synthetic */ v(BalanceAssetPresenter balanceAssetPresenter, int i11) {
        this.f46140b = balanceAssetPresenter;
        this.f46141c = i11;
    }

    public final void call(Object obj) {
        this.f46140b.e3(this.f46141c, (Boolean) obj);
    }
}
