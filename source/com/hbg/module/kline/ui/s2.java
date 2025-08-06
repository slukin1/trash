package com.hbg.module.kline.ui;

import android.view.View;
import com.hbg.lib.network.pro.core.bean.SymbolBean;

public final /* synthetic */ class s2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24271b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SymbolBean f24272c;

    public /* synthetic */ s2(MarketInfoFragment marketInfoFragment, SymbolBean symbolBean) {
        this.f24271b = marketInfoFragment;
        this.f24272c = symbolBean;
    }

    public final void onClick(View view) {
        this.f24271b.Ql(this.f24272c, view);
    }
}
