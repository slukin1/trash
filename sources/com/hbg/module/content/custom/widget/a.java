package com.hbg.module.content.custom.widget;

import android.widget.RadioGroup;

public final /* synthetic */ class a implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DoubleCoinChart f18210b;

    public /* synthetic */ a(DoubleCoinChart doubleCoinChart) {
        this.f18210b = doubleCoinChart;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        DoubleCoinChart.d0(this.f18210b, radioGroup, i11);
    }
}
