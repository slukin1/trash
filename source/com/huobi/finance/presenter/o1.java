package com.huobi.finance.presenter;

import com.huobi.finance.bean.BaseAssetTotal;
import rx.functions.Func4;

public final /* synthetic */ class o1 implements Func4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetPresenter f46032b;

    public /* synthetic */ o1(BalanceAssetPresenter balanceAssetPresenter) {
        this.f46032b = balanceAssetPresenter;
    }

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.f46032b.j3((BaseAssetTotal) obj, (BaseAssetTotal) obj2, (BaseAssetTotal) obj3, (BaseAssetTotal) obj4);
    }
}
