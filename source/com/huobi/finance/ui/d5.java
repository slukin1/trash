package com.huobi.finance.ui;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class d5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencySearchActivity f47087b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f47088c;

    public /* synthetic */ d5(CurrencySearchActivity currencySearchActivity, CurrencyBean currencyBean) {
        this.f47087b = currencySearchActivity;
        this.f47088c = currencyBean;
    }

    public final void call(Object obj) {
        this.f47087b.Wi(this.f47088c, (APIStatusErrorException) obj);
    }
}
