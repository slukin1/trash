package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65774a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f65775b;

    public /* synthetic */ p0(AnalyticsListener.EventTime eventTime, String str) {
        this.f65774a = eventTime;
        this.f65775b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoDecoderReleased(this.f65774a, this.f65775b);
    }
}
