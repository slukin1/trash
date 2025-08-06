package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class t0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f65795b;

    public /* synthetic */ t0(AnalyticsListener.EventTime eventTime, List list) {
        this.f65794a = eventTime;
        this.f65795b = list;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onStaticMetadataChanged(this.f65794a, this.f65795b);
    }
}
