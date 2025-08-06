package com.huobi.finance.presenter;

import com.huobi.finance.bean.SwapDataTotal;
import rx.functions.Action1;

public final /* synthetic */ class s implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46098b;

    public /* synthetic */ s(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46098b = balanceAssetPresenter;
    }

    public final void call(Object obj) {
        this.f46098b.o2((SwapDataTotal) obj);
    }
}
