package com.huobi.finance.ui;

import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import rx.functions.Action1;

public final /* synthetic */ class k9 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47207b;

    public /* synthetic */ k9(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog) {
        this.f47207b = unifyStableCurrencyExchangeDialog;
    }

    public final void call(Object obj) {
        this.f47207b.ai((StableCurrencyRateBean.StableCurrencyBean) obj);
    }
}
