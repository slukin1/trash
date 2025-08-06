package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseCarouselView f71762b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f71763c;

    public /* synthetic */ d(BaseCarouselView baseCarouselView, View view) {
        this.f71762b = baseCarouselView;
        this.f71763c = view;
    }

    public final void run() {
        this.f71762b.h(this.f71763c);
    }
}
