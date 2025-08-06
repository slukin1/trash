package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.finance.presenter.OtcCurrencyDetailPresenter;
import rx.functions.Action1;

public final /* synthetic */ class t5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyDetailPresenter.a f46119b;

    public /* synthetic */ t5(OtcCurrencyDetailPresenter.a aVar) {
        this.f46119b = aVar;
    }

    public final void call(Object obj) {
        this.f46119b.j((OtcFinanceResponse) obj);
    }
}
