package com.huobi.finance.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class r3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailActivity f47304b;

    public /* synthetic */ r3(CurrencyDetailActivity currencyDetailActivity) {
        this.f47304b = currencyDetailActivity;
    }

    public final void call(Object obj) {
        this.f47304b.gi((APIStatusErrorException) obj);
    }
}
