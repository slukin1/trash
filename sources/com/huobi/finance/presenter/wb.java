package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class wb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithdrawInfoConfirmPresenter f46167b;

    public /* synthetic */ wb(WithdrawInfoConfirmPresenter withdrawInfoConfirmPresenter) {
        this.f46167b = withdrawInfoConfirmPresenter;
    }

    public final void call(Object obj) {
        this.f46167b.m0((APIStatusErrorException) obj);
    }
}
