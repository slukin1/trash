package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class g implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f66967a;

    public /* synthetic */ g(String str) {
        this.f66967a = str;
    }

    public final Object get() {
        return ComponentDiscovery.instantiate(this.f66967a);
    }
}
