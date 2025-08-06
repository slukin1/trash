package com.huobi.otc.flutter;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DepositCurrencySearchFragment f78638b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f78639c;

    public /* synthetic */ d(DepositCurrencySearchFragment depositCurrencySearchFragment, CurrencyBean currencyBean) {
        this.f78638b = depositCurrencySearchFragment;
        this.f78639c = currencyBean;
    }

    public final void call(Object obj) {
        this.f78638b.fi(this.f78639c, (APIStatusErrorException) obj);
    }
}
