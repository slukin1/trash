package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import com.huobi.finance.presenter.OtcCurrencyFinanceRecordPresenter;
import rx.functions.Action1;

public final /* synthetic */ class f6 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyFinanceRecordPresenter.a f45878b;

    public /* synthetic */ f6(OtcCurrencyFinanceRecordPresenter.a aVar) {
        this.f45878b = aVar;
    }

    public final void call(Object obj) {
        this.f45878b.p((OtcFinanceResponse) obj);
    }
}
