package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter;
import rx.functions.Action1;

public final /* synthetic */ class e6 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyFinanceRecordPresenter.a f45865b;

    public /* synthetic */ e6(OtcCurrencyFinanceRecordPresenter.a aVar) {
        this.f45865b = aVar;
    }

    public final void call(Object obj) {
        this.f45865b.m((OtcFinanceResponse) obj);
    }
}
