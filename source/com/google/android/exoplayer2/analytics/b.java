package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65690a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65691b;

    public /* synthetic */ b(AnalyticsListener.EventTime eventTime, int i11) {
        this.f65690a = eventTime;
        this.f65691b = i11;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onDrmSessionAcquired$53(this.f65690a, this.f65691b, (AnalyticsListener) obj);
    }
}
