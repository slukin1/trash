package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f65693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f65694c;

    public /* synthetic */ b0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f65692a = eventTime;
        this.f65693b = loadEventInfo;
        this.f65694c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadStarted(this.f65692a, this.f65693b, this.f65694c);
    }
}
