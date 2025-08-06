package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65804a;

    public /* synthetic */ w(AnalyticsListener.EventTime eventTime) {
        this.f65804a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSeekProcessed(this.f65804a);
    }
}
