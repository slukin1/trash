package com.hbg.lib.widgets;

import android.view.View;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseCarouselView f71757b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f71758c;

    public /* synthetic */ c(BaseCarouselView baseCarouselView, View view) {
        this.f71757b = baseCarouselView;
        this.f71758c = view;
    }

    public final void run() {
        this.f71757b.g(this.f71758c);
    }
}
