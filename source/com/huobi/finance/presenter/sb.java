package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class sb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f46110b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f46111c;

    public /* synthetic */ sb(UsdtExchangePresenter usdtExchangePresenter, List list) {
        this.f46110b = usdtExchangePresenter;
        this.f46111c = list;
    }

    public final void call(Object obj) {
        this.f46110b.y0(this.f46111c, (HbgIntCodeResponse) obj);
    }
}
