package com.huobi.finance.presenter;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class p2 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailPresenter f46052b;

    public /* synthetic */ p2(CurrencyDetailPresenter currencyDetailPresenter) {
        this.f46052b = currencyDetailPresenter;
    }

    public final Object call(Object obj) {
        return this.f46052b.C0((BalanceQueryData) obj);
    }
}
