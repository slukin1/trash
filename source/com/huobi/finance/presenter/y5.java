package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class y5 implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFinanceResponse f46190b;

    public /* synthetic */ y5(OtcFinanceResponse otcFinanceResponse) {
        this.f46190b = otcFinanceResponse;
    }

    public final void call(Object obj) {
        OtcCurrencyFinanceRecordPresenter.q0(this.f46190b, (Subscriber) obj);
    }
}
