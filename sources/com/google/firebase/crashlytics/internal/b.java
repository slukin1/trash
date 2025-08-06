package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f67045a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f67046b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f67047c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StaticSessionData f67048d;

    public /* synthetic */ b(String str, String str2, long j11, StaticSessionData staticSessionData) {
        this.f67045a = str;
        this.f67046b = str2;
        this.f67047c = j11;
        this.f67048d = staticSessionData;
    }

    public final void handle(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(this.f67045a, this.f67046b, this.f67047c, this.f67048d);
    }
}
