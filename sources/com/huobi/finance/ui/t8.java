package com.huobi.finance.ui;

import com.huobi.finance.bean.StableCurrencyBeanInfo;
import rx.functions.Action1;

public final /* synthetic */ class t8 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47338b;

    public /* synthetic */ t8(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog) {
        this.f47338b = unifyStableCurrencyExchangeDialog;
    }

    public final void call(Object obj) {
        this.f47338b.ei((StableCurrencyBeanInfo) obj);
    }
}
