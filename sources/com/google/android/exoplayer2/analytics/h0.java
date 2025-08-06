package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65735a;

    public /* synthetic */ h0(AnalyticsListener.EventTime eventTime) {
        this.f65735a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerReleased(this.f65735a);
    }
}
