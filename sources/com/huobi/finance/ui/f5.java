package com.huobi.finance.ui;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class f5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencySearchActivity f47118b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f47119c;

    public /* synthetic */ f5(CurrencySearchActivity currencySearchActivity, CurrencyBean currencyBean) {
        this.f47118b = currencySearchActivity;
        this.f47119c = currencyBean;
    }

    public final void call(Object obj) {
        this.f47118b.Vi(this.f47119c, (Boolean) obj);
    }
}
