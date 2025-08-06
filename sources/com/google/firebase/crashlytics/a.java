package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;

public final /* synthetic */ class a implements AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f67040a;

    public /* synthetic */ a(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f67040a = analyticsDeferredProxy;
    }

    public final void logEvent(String str, Bundle bundle) {
        this.f67040a.lambda$getAnalyticsEventLogger$1(str, bundle);
    }
}
