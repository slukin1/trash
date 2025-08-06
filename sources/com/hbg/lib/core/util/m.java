package com.hbg.lib.core.util;

import android.view.View;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f68722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f68723c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f68724d;

    public /* synthetic */ m(n nVar, View view, String str) {
        this.f68722b = nVar;
        this.f68723c = view;
        this.f68724d = str;
    }

    public final void run() {
        this.f68722b.u(this.f68723c, this.f68724d);
    }
}
