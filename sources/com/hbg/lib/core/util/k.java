package com.hbg.lib.core.util;

import android.view.View;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f68716b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f68717c;

    public /* synthetic */ k(n nVar, View view) {
        this.f68716b = nVar;
        this.f68717c = view;
    }

    public final void run() {
        this.f68716b.w(this.f68717c);
    }
}
