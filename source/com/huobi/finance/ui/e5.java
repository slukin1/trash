package com.huobi.finance.ui;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class e5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencySearchActivity f47101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f47102c;

    public /* synthetic */ e5(CurrencySearchActivity currencySearchActivity, CurrencyBean currencyBean) {
        this.f47101b = currencySearchActivity;
        this.f47102c = currencyBean;
    }

    public final void call(Object obj) {
        this.f47101b.Zi(this.f47102c, (APIStatusErrorException) obj);
    }
}
