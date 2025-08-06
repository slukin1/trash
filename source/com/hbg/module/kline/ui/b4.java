package com.hbg.module.kline.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.KlineContractBottomBean;
import com.hbg.module.kline.ui.MarketInfoFragment;

public final /* synthetic */ class b4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment.k f24157b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KlineContractBottomBean f24158c;

    public /* synthetic */ b4(MarketInfoFragment.k kVar, KlineContractBottomBean klineContractBottomBean) {
        this.f24157b = kVar;
        this.f24158c = klineContractBottomBean;
    }

    public final void onClick(View view) {
        this.f24157b.c(this.f24158c, view);
    }
}
