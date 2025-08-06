package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.presenter.UsdtExchangePresenter;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class kb implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ kb f45962b = new kb();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return new UsdtExchangePresenter.c((UsdtExchangeConfig) obj, (List) obj2, (BalanceDataTotal) obj3);
    }
}
