package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class vb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithdrawInfoConfirmPresenter f46153b;

    public /* synthetic */ vb(WithdrawInfoConfirmPresenter withdrawInfoConfirmPresenter) {
        this.f46153b = withdrawInfoConfirmPresenter;
    }

    public final void call(Object obj) {
        this.f46153b.r0((APIStatusErrorException) obj);
    }
}
