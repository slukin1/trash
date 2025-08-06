package com.hbg.module.kline.ui;

import android.view.View;

public final /* synthetic */ class u2 implements View.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24284a;

    public /* synthetic */ u2(MarketInfoFragment marketInfoFragment) {
        this.f24284a = marketInfoFragment;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        this.f24284a.ql(view, i11, i12, i13, i14);
    }
}
