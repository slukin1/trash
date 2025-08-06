package com.hbg.module.kline.ui;

import android.view.View;
import c6.b;

public final /* synthetic */ class f implements b {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractKlineActivity f24180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f24181c;

    public /* synthetic */ f(AbstractKlineActivity abstractKlineActivity, View view) {
        this.f24180b = abstractKlineActivity;
        this.f24181c = view;
    }

    public final void onCallback(Object obj) {
        this.f24180b.ni(this.f24181c, (View) obj);
    }
}
