package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class ab implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45807b;

    public /* synthetic */ ab(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f45807b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f45807b.x1((APIStatusErrorException) obj);
    }
}
