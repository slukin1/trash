package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65709a;

    public /* synthetic */ d1(AnalyticsListener.EventTime eventTime) {
        this.f65709a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSeekStarted(this.f65709a);
    }
}
