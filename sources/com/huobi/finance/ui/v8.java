package com.huobi.finance.ui;

import com.huobi.currencyconfig.bean.StableCoinHints;
import rx.functions.Func1;

public final /* synthetic */ class v8 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47365b;

    public /* synthetic */ v8(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog) {
        this.f47365b = unifyStableCurrencyExchangeDialog;
    }

    public final Object call(Object obj) {
        return this.f47365b.ci((StableCoinHints) obj);
    }
}
