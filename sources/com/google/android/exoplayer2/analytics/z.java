package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65816a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Metadata f65817b;

    public /* synthetic */ z(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        this.f65816a = eventTime;
        this.f65817b = metadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMetadata(this.f65816a, this.f65817b);
    }
}
