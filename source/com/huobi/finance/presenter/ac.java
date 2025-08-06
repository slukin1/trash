package com.huobi.finance.presenter;

import com.huobi.finance.model.WithdrawRequestParams;
import rx.functions.Action1;

public final /* synthetic */ class ac implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WithdrawInfoConfirmPresenter f45808b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WithdrawRequestParams f45809c;

    public /* synthetic */ ac(WithdrawInfoConfirmPresenter withdrawInfoConfirmPresenter, WithdrawRequestParams withdrawRequestParams) {
        this.f45808b = withdrawInfoConfirmPresenter;
        this.f45809c = withdrawRequestParams;
    }

    public final void call(Object obj) {
        this.f45808b.q0(this.f45809c, (String) obj);
    }
}
