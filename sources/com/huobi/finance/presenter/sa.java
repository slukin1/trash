package com.huobi.finance.presenter;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class sa implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f46109b;

    public /* synthetic */ sa(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f46109b = unifyWithdrawPresenter;
    }

    public final Object call(Object obj) {
        return this.f46109b.m1((BalanceQueryData) obj);
    }
}
