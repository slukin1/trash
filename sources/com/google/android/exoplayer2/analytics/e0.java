package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f65713b;

    public /* synthetic */ e0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f65712a = eventTime;
        this.f65713b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onUpstreamDiscarded(this.f65712a, this.f65713b);
    }
}
