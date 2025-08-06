package com.huobi.view;

import android.view.View;

public final /* synthetic */ class q0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyKlineBubblePopup f19096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f19097c;

    public /* synthetic */ q0(HeavyKlineBubblePopup heavyKlineBubblePopup, View.OnClickListener onClickListener) {
        this.f19096b = heavyKlineBubblePopup;
        this.f19097c = onClickListener;
    }

    public final void onClick(View view) {
        this.f19096b.lambda$setPosListener$1(this.f19097c, view);
    }
}
