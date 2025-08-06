package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65685a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f65686b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f65687c;

    public /* synthetic */ a0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f65685a = eventTime;
        this.f65686b = loadEventInfo;
        this.f65687c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadCompleted(this.f65685a, this.f65686b, this.f65687c);
    }
}
