package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OptionalProvider f66975b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Provider f66976c;

    public /* synthetic */ m(OptionalProvider optionalProvider, Provider provider) {
        this.f66975b = optionalProvider;
        this.f66976c = provider;
    }

    public final void run() {
        this.f66975b.set(this.f66976c);
    }
}
