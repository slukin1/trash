package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class i implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f66969a;

    public /* synthetic */ i(ComponentRegistrar componentRegistrar) {
        this.f66969a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.lambda$toProviders$1(this.f66969a);
    }
}
