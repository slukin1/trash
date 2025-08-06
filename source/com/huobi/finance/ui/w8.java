package com.huobi.finance.ui;

import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import rx.functions.Func1;

public final /* synthetic */ class w8 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47381b;

    public /* synthetic */ w8(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog) {
        this.f47381b = unifyStableCurrencyExchangeDialog;
    }

    public final Object call(Object obj) {
        return this.f47381b.gi((StableCurrencyRateBean.StableCurrencyBean) obj);
    }
}
