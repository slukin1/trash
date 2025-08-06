package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f65720b;

    public /* synthetic */ f0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f65719a = eventTime;
        this.f65720b = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDownstreamFormatChanged(this.f65719a, this.f65720b);
    }
}
