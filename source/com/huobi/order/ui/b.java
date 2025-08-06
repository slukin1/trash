package com.huobi.order.ui;

import android.widget.FrameLayout;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseOrderActivity f78221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f78222c;

    public /* synthetic */ b(BaseOrderActivity baseOrderActivity, FrameLayout.LayoutParams layoutParams) {
        this.f78221b = baseOrderActivity;
        this.f78222c = layoutParams;
    }

    public final void run() {
        this.f78221b.yh(this.f78222c);
    }
}
