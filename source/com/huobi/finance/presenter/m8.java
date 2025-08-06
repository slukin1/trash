package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class m8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46002c;

    public /* synthetic */ m8(UnifyTransferPresenter unifyTransferPresenter, String str) {
        this.f46001b = unifyTransferPresenter;
        this.f46002c = str;
    }

    public final void call(Object obj) {
        this.f46001b.u3(this.f46002c, (String) obj);
    }
}
