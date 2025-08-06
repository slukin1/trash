package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65798a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f65799b;

    public /* synthetic */ u0(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f65798a = eventTime;
        this.f65799b = z11;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onIsLoadingChanged$39(this.f65798a, this.f65799b, (AnalyticsListener) obj);
    }
}
