package com.huobi.finance.presenter;

import rx.functions.Action1;

public final /* synthetic */ class o2 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailPresenter f46033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f46034c;

    public /* synthetic */ o2(CurrencyDetailPresenter currencyDetailPresenter, boolean z11) {
        this.f46033b = currencyDetailPresenter;
        this.f46034c = z11;
    }

    public final void call(Object obj) {
        this.f46033b.D0(this.f46034c, (Long) obj);
    }
}
