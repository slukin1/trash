package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class j8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f45940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45941c;

    public /* synthetic */ j8(UnifyTransferPresenter unifyTransferPresenter, String str) {
        this.f45940b = unifyTransferPresenter;
        this.f45941c = str;
    }

    public final void call(Object obj) {
        this.f45940b.j3(this.f45941c, (Long) obj);
    }
}
