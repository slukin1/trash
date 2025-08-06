package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class r8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f46091b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f46092c;

    public /* synthetic */ r8(UnifyTransferPresenter unifyTransferPresenter, boolean z11) {
        this.f46091b = unifyTransferPresenter;
        this.f46092c = z11;
    }

    public final void call(Object obj) {
        this.f46091b.D2(this.f46092c, (Long) obj);
    }
}
