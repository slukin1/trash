package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class d implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsRegistrar f67043a;

    public /* synthetic */ d(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f67043a = crashlyticsRegistrar;
    }

    public final Object create(ComponentContainer componentContainer) {
        return this.f67043a.buildCrashlytics(componentContainer);
    }
}
