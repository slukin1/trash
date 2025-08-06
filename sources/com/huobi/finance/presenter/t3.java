package com.huobi.finance.presenter;

import com.huobi.finance.bean.FinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class t3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyHistoryPresenter f46116b;

    public /* synthetic */ t3(CurrencyHistoryPresenter currencyHistoryPresenter) {
        this.f46116b = currencyHistoryPresenter;
    }

    public final Object call(Object obj) {
        return this.f46116b.g0((FinanceRecordItem) obj);
    }
}
