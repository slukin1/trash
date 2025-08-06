package com.huobi.finance.presenter;

import com.huobi.finance.bean.CurrencyIntroBean;
import rx.functions.Action1;

public final /* synthetic */ class h3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l3 f45904b;

    public /* synthetic */ h3(l3 l3Var) {
        this.f45904b = l3Var;
    }

    public final void call(Object obj) {
        this.f45904b.S((CurrencyIntroBean.TradeItem) obj);
    }
}
