package com.huobi.finance.ui;

import androidx.core.widget.NestedScrollView;

public final /* synthetic */ class gc implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ hc f47143b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f47144c;

    public /* synthetic */ gc(hc hcVar, NestedScrollView nestedScrollView) {
        this.f47143b = hcVar;
        this.f47144c = nestedScrollView;
    }

    public final void run() {
        this.f47143b.h(this.f47144c);
    }
}
