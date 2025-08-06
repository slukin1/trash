package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.finance.presenter.OtcCurrencyDetailPresenter;
import rx.functions.Action1;

public final /* synthetic */ class s5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyDetailPresenter.a f46104b;

    public /* synthetic */ s5(OtcCurrencyDetailPresenter.a aVar) {
        this.f46104b = aVar;
    }

    public final void call(Object obj) {
        this.f46104b.l((OtcFinanceResponse) obj);
    }
}
