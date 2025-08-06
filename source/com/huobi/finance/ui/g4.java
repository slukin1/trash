package com.huobi.finance.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class g4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailActivity f47132b;

    public /* synthetic */ g4(CurrencyDetailActivity currencyDetailActivity) {
        this.f47132b = currencyDetailActivity;
    }

    public final void call(Object obj) {
        this.f47132b.ii((APIStatusErrorException) obj);
    }
}
