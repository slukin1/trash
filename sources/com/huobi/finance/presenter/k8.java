package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class k8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f45958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f45959c;

    public /* synthetic */ k8(UnifyTransferPresenter unifyTransferPresenter, String str) {
        this.f45958b = unifyTransferPresenter;
        this.f45959c = str;
    }

    public final void call(Object obj) {
        this.f45958b.w3(this.f45959c, (Long) obj);
    }
}
