package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65749a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f65750b;

    public /* synthetic */ k(AnalyticsListener.EventTime eventTime, long j11) {
        this.f65749a = eventTime;
        this.f65750b = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioPositionAdvancing(this.f65749a, this.f65750b);
    }
}
