package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65698a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f65699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f65700c;

    public /* synthetic */ c0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.f65698a = eventTime;
        this.f65699b = loadEventInfo;
        this.f65700c = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onLoadCanceled(this.f65698a, this.f65699b, this.f65700c);
    }
}
