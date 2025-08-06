package com.huobi.finance.ui;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class h5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencySearchActivity f47151b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f47152c;

    public /* synthetic */ h5(CurrencySearchActivity currencySearchActivity, CurrencyBean currencyBean) {
        this.f47151b = currencySearchActivity;
        this.f47152c = currencyBean;
    }

    public final void call(Object obj) {
        this.f47151b.aj(this.f47152c, (Throwable) obj);
    }
}
