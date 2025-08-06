package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65684a;

    public /* synthetic */ a(AnalyticsListener.EventTime eventTime) {
        this.f65684a = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmKeysLoaded(this.f65684a);
    }
}
