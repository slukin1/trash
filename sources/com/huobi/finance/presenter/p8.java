package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class p8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46058b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f46059c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f46060d;

    public /* synthetic */ p8(UnifyTransferPresenter unifyTransferPresenter, String str, String str2) {
        this.f46058b = unifyTransferPresenter;
        this.f46059c = str;
        this.f46060d = str2;
    }

    public final void call(Object obj) {
        this.f46058b.U2(this.f46059c, this.f46060d, obj);
    }
}
