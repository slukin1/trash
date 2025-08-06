package com.huobi.finance.presenter;

import com.huobi.finance.bean.CurrencyIntroBean;
import rx.functions.Action1;

public final /* synthetic */ class g3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l3 f45890b;

    public /* synthetic */ g3(l3 l3Var) {
        this.f45890b = l3Var;
    }

    public final void call(Object obj) {
        this.f45890b.T((CurrencyIntroBean.TradeItem) obj);
    }
}
