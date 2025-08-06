package com.huobi.view;

import android.view.View;

public final /* synthetic */ class m0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyBubblePopup f19072b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f19073c;

    public /* synthetic */ m0(HeavyBubblePopup heavyBubblePopup, View.OnClickListener onClickListener) {
        this.f19072b = heavyBubblePopup;
        this.f19073c = onClickListener;
    }

    public final void onClick(View view) {
        this.f19072b.lambda$setPosListener$1(this.f19073c, view);
    }
}
