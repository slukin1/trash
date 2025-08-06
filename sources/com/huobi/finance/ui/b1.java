package com.huobi.finance.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class b1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotCurrencyDetailActivity f47052b;

    public /* synthetic */ b1(AssetSpotCurrencyDetailActivity assetSpotCurrencyDetailActivity) {
        this.f47052b = assetSpotCurrencyDetailActivity;
    }

    public final void call(Object obj) {
        this.f47052b.Xi((APIStatusErrorException) obj);
    }
}
