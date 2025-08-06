package com.hbg.lib.core.util;

import android.view.View;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f68719b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f68720c;

    public /* synthetic */ l(n nVar, View view) {
        this.f68719b = nVar;
        this.f68720c = view;
    }

    public final void run() {
        this.f68719b.y(this.f68720c);
    }
}
