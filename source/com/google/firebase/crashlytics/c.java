package com.google.firebase.crashlytics;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class c implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f67042a;

    public /* synthetic */ c(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f67042a = analyticsDeferredProxy;
    }

    public final void handle(Provider provider) {
        this.f67042a.lambda$init$2(provider);
    }
}
