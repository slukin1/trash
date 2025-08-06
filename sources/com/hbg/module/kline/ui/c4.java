package com.hbg.module.kline.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.KlineBottomBean;
import com.hbg.module.kline.ui.MarketInfoFragment;

public final /* synthetic */ class c4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment.m f24164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KlineBottomBean f24165c;

    public /* synthetic */ c4(MarketInfoFragment.m mVar, KlineBottomBean klineBottomBean) {
        this.f24164b = mVar;
        this.f24165c = klineBottomBean;
    }

    public final void onClick(View view) {
        this.f24164b.e(this.f24165c, view);
    }
}
