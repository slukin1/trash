package com.huobi.finance.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class a1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotCurrencyDetailActivity f47037b;

    public /* synthetic */ a1(AssetSpotCurrencyDetailActivity assetSpotCurrencyDetailActivity) {
        this.f47037b = assetSpotCurrencyDetailActivity;
    }

    public final void call(Object obj) {
        this.f47037b.Ti((APIStatusErrorException) obj);
    }
}
