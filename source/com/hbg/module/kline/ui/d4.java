package com.hbg.module.kline.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.KlineBottomBean;
import com.hbg.module.kline.ui.MarketInfoFragment;

public final /* synthetic */ class d4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment.m f24171b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KlineBottomBean f24172c;

    public /* synthetic */ d4(MarketInfoFragment.m mVar, KlineBottomBean klineBottomBean) {
        this.f24171b = mVar;
        this.f24172c = klineBottomBean;
    }

    public final void onClick(View view) {
        this.f24171b.f(this.f24172c, view);
    }
}
