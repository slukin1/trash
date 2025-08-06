package com.huobi.copytrading.ui;

import android.view.View;
import com.huobi.view.radiogroup.RadioGroupContainer;

public final /* synthetic */ class k implements RadioGroupContainer.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CopyTradingMainActivity f43694a;

    public /* synthetic */ k(CopyTradingMainActivity copyTradingMainActivity) {
        this.f43694a = copyTradingMainActivity;
    }

    public final void onCheckedChanged(RadioGroupContainer radioGroupContainer, View view, int i11, int i12) {
        CopyTradingMainActivity.Eh(this.f43694a, radioGroupContainer, view, i11, i12);
    }
}
