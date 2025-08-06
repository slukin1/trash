package com.huobi.finance.presenter;

import com.huobi.account.entity.LegalQueryData;
import rx.functions.Func1;

public final /* synthetic */ class p5 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyDetailPresenter f46055b;

    public /* synthetic */ p5(OtcCurrencyDetailPresenter otcCurrencyDetailPresenter) {
        this.f46055b = otcCurrencyDetailPresenter;
    }

    public final Object call(Object obj) {
        return this.f46055b.p0((LegalQueryData) obj);
    }
}
