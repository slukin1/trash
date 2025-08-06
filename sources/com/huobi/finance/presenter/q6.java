package com.huobi.finance.presenter;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class q6 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SavingsCurrencyDetailPresenter f46074b;

    public /* synthetic */ q6(SavingsCurrencyDetailPresenter savingsCurrencyDetailPresenter) {
        this.f46074b = savingsCurrencyDetailPresenter;
    }

    public final Object call(Object obj) {
        return this.f46074b.h0((BalanceQueryData) obj);
    }
}
