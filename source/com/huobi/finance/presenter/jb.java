package com.huobi.finance.presenter;

import com.huobi.finance.bean.BaseAssetInfo;
import rx.functions.Func2;

public final /* synthetic */ class jb implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f45944b;

    public /* synthetic */ jb(UsdtExchangePresenter usdtExchangePresenter) {
        this.f45944b = usdtExchangePresenter;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f45944b.w0((BaseAssetInfo) obj, (BaseAssetInfo) obj2);
    }
}
