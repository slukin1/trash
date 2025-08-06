package com.huobi.finance.ui;

import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import rx.functions.Func1;

public final /* synthetic */ class x8 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47400b;

    public /* synthetic */ x8(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog) {
        this.f47400b = unifyStableCurrencyExchangeDialog;
    }

    public final Object call(Object obj) {
        return this.f47400b.ii((StableCurrencyRateBean.StableCurrencyBean) obj);
    }
}
