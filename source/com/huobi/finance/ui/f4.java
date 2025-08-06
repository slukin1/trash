package com.huobi.finance.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.MaxRateMiningProject;

public final /* synthetic */ class f4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailActivity f47116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MaxRateMiningProject f47117c;

    public /* synthetic */ f4(CurrencyDetailActivity currencyDetailActivity, MaxRateMiningProject maxRateMiningProject) {
        this.f47116b = currencyDetailActivity;
        this.f47117c = maxRateMiningProject;
    }

    public final void onClick(View view) {
        this.f47116b.mi(this.f47117c, view);
    }
}
