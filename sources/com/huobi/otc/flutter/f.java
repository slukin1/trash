package com.huobi.otc.flutter;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DepositCurrencySearchFragment f78644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f78645c;

    public /* synthetic */ f(DepositCurrencySearchFragment depositCurrencySearchFragment, CurrencyBean currencyBean) {
        this.f78644b = depositCurrencySearchFragment;
        this.f78645c = currencyBean;
    }

    public final void call(Object obj) {
        this.f78644b.gi(this.f78645c, (Throwable) obj);
    }
}
