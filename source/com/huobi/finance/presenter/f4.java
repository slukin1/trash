package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import rx.functions.Action1;

public final /* synthetic */ class f4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HtExchangePresenter f45876b;

    public /* synthetic */ f4(HtExchangePresenter htExchangePresenter) {
        this.f45876b = htExchangePresenter;
    }

    public final void call(Object obj) {
        this.f45876b.l0((HbgIntCodeResponse) obj);
    }
}
