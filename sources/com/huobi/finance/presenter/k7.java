package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class k7 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyDepositPresenter f45957b;

    public /* synthetic */ k7(UnifyDepositPresenter unifyDepositPresenter) {
        this.f45957b = unifyDepositPresenter;
    }

    public final void call(Object obj) {
        this.f45957b.O0((APIStatusErrorException) obj);
    }
}
