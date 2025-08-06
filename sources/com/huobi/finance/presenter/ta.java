package com.huobi.finance.presenter;

import com.huobi.finance.bean.WithdrawInfo;
import rx.functions.Func1;

public final /* synthetic */ class ta implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f46124b;

    public /* synthetic */ ta(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f46124b = unifyWithdrawPresenter;
    }

    public final Object call(Object obj) {
        return this.f46124b.v1((WithdrawInfo) obj);
    }
}
