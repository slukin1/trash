package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class n8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46016b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46017c;

    public /* synthetic */ n8(UnifyTransferPresenter unifyTransferPresenter, String str) {
        this.f46016b = unifyTransferPresenter;
        this.f46017c = str;
    }

    public final void call(Object obj) {
        this.f46016b.k3(this.f46017c, obj);
    }
}
