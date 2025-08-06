package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class cb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45842b;

    public /* synthetic */ cb(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f45842b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f45842b.H1((APIStatusErrorException) obj);
    }
}
