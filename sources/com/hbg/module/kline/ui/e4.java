package com.hbg.module.kline.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.KlineBottomBean;
import com.hbg.module.kline.ui.MarketInfoFragment;

public final /* synthetic */ class e4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment.m f24178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KlineBottomBean f24179c;

    public /* synthetic */ e4(MarketInfoFragment.m mVar, KlineBottomBean klineBottomBean) {
        this.f24178b = mVar;
        this.f24179c = klineBottomBean;
    }

    public final void onClick(View view) {
        this.f24178b.d(this.f24179c, view);
    }
}
