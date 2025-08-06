package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class j implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f66970a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f66971b;

    public /* synthetic */ j(ComponentRuntime componentRuntime, Component component) {
        this.f66970a = componentRuntime;
        this.f66971b = component;
    }

    public final Object get() {
        return this.f66970a.lambda$discoverComponents$0(this.f66971b);
    }
}
