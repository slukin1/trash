package com.huobi.tradenew.ui;

import android.view.View;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SpotMarginFuncDialogFragment f83406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Integer f83407c;

    public /* synthetic */ g(SpotMarginFuncDialogFragment spotMarginFuncDialogFragment, Integer num) {
        this.f83406b = spotMarginFuncDialogFragment;
        this.f83407c = num;
    }

    public final void onClick(View view) {
        this.f83406b.xh(this.f83407c, view);
    }
}
