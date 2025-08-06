package com.huobi.finance.presenter;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class y4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MineCurrencyDetailPresenter f46189b;

    public /* synthetic */ y4(MineCurrencyDetailPresenter mineCurrencyDetailPresenter) {
        this.f46189b = mineCurrencyDetailPresenter;
    }

    public final Object call(Object obj) {
        return this.f46189b.A0((BalanceQueryData) obj);
    }
}
