package com.huobi.finance.ui;

import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import rx.functions.Action1;

public final /* synthetic */ class g5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencySearchActivity f47133b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrencyBean f47134c;

    public /* synthetic */ g5(CurrencySearchActivity currencySearchActivity, CurrencyBean currencyBean) {
        this.f47133b = currencySearchActivity;
        this.f47134c = currencyBean;
    }

    public final void call(Object obj) {
        this.f47133b.Yi(this.f47134c, (Boolean) obj);
    }
}
