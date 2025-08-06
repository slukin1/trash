package com.hbg.lib.widgets;

import com.hbg.lib.widgets.CommonShimmerLayout;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonShimmerLayout f72406b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommonShimmerLayout.b[] f72407c;

    public /* synthetic */ u(CommonShimmerLayout commonShimmerLayout, CommonShimmerLayout.b[] bVarArr) {
        this.f72406b = commonShimmerLayout;
        this.f72407c = bVarArr;
    }

    public final void run() {
        this.f72406b.g(this.f72407c);
    }
}
