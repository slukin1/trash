package com.hbg.module.kline.ui;

import com.hbg.lib.network.hbg.core.bean.KlineLabel;
import rx.functions.Action1;

public final /* synthetic */ class o3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24246b;

    public /* synthetic */ o3(MarketInfoFragment marketInfoFragment) {
        this.f24246b = marketInfoFragment;
    }

    public final void call(Object obj) {
        this.f24246b.dm((KlineLabel) obj);
    }
}
