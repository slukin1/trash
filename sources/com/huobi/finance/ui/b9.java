package com.huobi.finance.ui;

import com.huobi.account.entity.BalanceQueryData;
import com.huobi.currencyconfig.bean.StableCoinHints;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import rx.functions.Func3;

public final /* synthetic */ class b9 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47060b;

    public /* synthetic */ b9(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog) {
        this.f47060b = unifyStableCurrencyExchangeDialog;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f47060b.di((StableCurrencyRateBean.StableCurrencyBean) obj, (BalanceQueryData) obj2, (StableCoinHints) obj3);
    }
}
