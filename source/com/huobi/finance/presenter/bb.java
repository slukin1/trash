package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class bb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45823b;

    public /* synthetic */ bb(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f45823b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f45823b.L1((APIStatusErrorException) obj);
    }
}
