package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LazySet f66973b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Provider f66974c;

    public /* synthetic */ l(LazySet lazySet, Provider provider) {
        this.f66973b = lazySet;
        this.f66974c = provider;
    }

    public final void run() {
        this.f66973b.add(this.f66974c);
    }
}
