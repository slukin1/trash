package com.huobi.finance.presenter;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class m3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyFromCCDetailPresenter f45996b;

    public /* synthetic */ m3(CurrencyFromCCDetailPresenter currencyFromCCDetailPresenter) {
        this.f45996b = currencyFromCCDetailPresenter;
    }

    public final Object call(Object obj) {
        return this.f45996b.j0((BalanceQueryData) obj);
    }
}
