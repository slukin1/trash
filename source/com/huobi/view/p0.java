package com.huobi.view;

import android.view.View;

public final /* synthetic */ class p0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyKlineBubblePopup f19085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f19086c;

    public /* synthetic */ p0(HeavyKlineBubblePopup heavyKlineBubblePopup, View.OnClickListener onClickListener) {
        this.f19085b = heavyKlineBubblePopup;
        this.f19086c = onClickListener;
    }

    public final void onClick(View view) {
        this.f19085b.lambda$setNegListener$0(this.f19086c, view);
    }
}
