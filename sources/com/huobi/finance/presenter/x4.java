package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class x4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MineCurrencyDetailPresenter f46173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f46174c;

    public /* synthetic */ x4(MineCurrencyDetailPresenter mineCurrencyDetailPresenter, boolean z11) {
        this.f46173b = mineCurrencyDetailPresenter;
        this.f46174c = z11;
    }

    public final void call(Object obj) {
        this.f46173b.B0(this.f46174c, (Long) obj);
    }
}
