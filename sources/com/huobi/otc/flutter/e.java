package com.huobi.otc.flutter;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DepositCurrencySearchFragment f78641b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f78642c;

    public /* synthetic */ e(DepositCurrencySearchFragment depositCurrencySearchFragment, CurrencyBean currencyBean) {
        this.f78641b = depositCurrencySearchFragment;
        this.f78642c = currencyBean;
    }

    public final void call(Object obj) {
        this.f78641b.ei(this.f78642c, (Boolean) obj);
    }
}
