package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import rx.functions.Action1;

public final /* synthetic */ class nb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f46029b;

    public /* synthetic */ nb(UsdtExchangePresenter usdtExchangePresenter) {
        this.f46029b = usdtExchangePresenter;
    }

    public final void call(Object obj) {
        this.f46029b.t0((HbgIntCodeResponse) obj);
    }
}
