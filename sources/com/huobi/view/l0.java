package com.huobi.view;

import android.view.View;

public final /* synthetic */ class l0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeavyBubblePopup f19066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f19067c;

    public /* synthetic */ l0(HeavyBubblePopup heavyBubblePopup, View.OnClickListener onClickListener) {
        this.f19066b = heavyBubblePopup;
        this.f19067c = onClickListener;
    }

    public final void onClick(View view) {
        this.f19066b.lambda$setNegListener$0(this.f19067c, view);
    }
}
