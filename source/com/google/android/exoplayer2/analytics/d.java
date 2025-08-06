package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65703b;

    public /* synthetic */ d(AnalyticsListener.EventTime eventTime, int i11) {
        this.f65702a = eventTime;
        this.f65703b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTimelineChanged(this.f65702a, this.f65703b);
    }
}
