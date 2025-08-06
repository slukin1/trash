package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class n5 implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFinanceResponse f46013b;

    public /* synthetic */ n5(OtcFinanceResponse otcFinanceResponse) {
        this.f46013b = otcFinanceResponse;
    }

    public final void call(Object obj) {
        OtcCurrencyDetailPresenter.q0(this.f46013b, (Subscriber) obj);
    }
}
