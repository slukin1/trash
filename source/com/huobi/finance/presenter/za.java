package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class za implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f46208b;

    public /* synthetic */ za(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f46208b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f46208b.D1((APIStatusErrorException) obj);
    }
}
