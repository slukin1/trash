package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

public final /* synthetic */ class b implements BreadcrumbSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f67041a;

    public /* synthetic */ b(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f67041a = analyticsDeferredProxy;
    }

    public final void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.f67041a.lambda$getDeferredBreadcrumbSource$0(breadcrumbHandler);
    }
}
