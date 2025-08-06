package com.huobi.finance.presenter;

import com.huobi.account.entity.LegalQueryData;
import com.huobi.finance.bean.LegalDataTotal;
import rx.functions.Func1;

public final /* synthetic */ class q5 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyDetailPresenter f46072b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LegalQueryData f46073c;

    public /* synthetic */ q5(OtcCurrencyDetailPresenter otcCurrencyDetailPresenter, LegalQueryData legalQueryData) {
        this.f46072b = otcCurrencyDetailPresenter;
        this.f46073c = legalQueryData;
    }

    public final Object call(Object obj) {
        return this.f46072b.n0(this.f46073c, (LegalDataTotal) obj);
    }
}
