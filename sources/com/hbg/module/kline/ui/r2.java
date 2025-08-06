package com.hbg.module.kline.ui;

import android.view.View;
import com.hbg.lib.network.pro.core.bean.SymbolBean;

public final /* synthetic */ class r2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SymbolBean f24265c;

    public /* synthetic */ r2(MarketInfoFragment marketInfoFragment, SymbolBean symbolBean) {
        this.f24264b = marketInfoFragment;
        this.f24265c = symbolBean;
    }

    public final void onClick(View view) {
        this.f24264b.Pl(this.f24265c, view);
    }
}
