package com.huobi.finance.presenter;

import com.huobi.finance.bean.BaseAssetTotal;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46126b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f46127c;

    public /* synthetic */ u(BalanceAssetPresenter balanceAssetPresenter, int i11) {
        this.f46126b = balanceAssetPresenter;
        this.f46127c = i11;
    }

    public final void call(Object obj) {
        this.f46126b.B2(this.f46127c, (BaseAssetTotal) obj);
    }
}
