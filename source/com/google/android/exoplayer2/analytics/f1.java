package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65722b;

    public /* synthetic */ f1(AnalyticsListener.EventTime eventTime, int i11) {
        this.f65721a = eventTime;
        this.f65722b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackSuppressionReasonChanged(this.f65721a, this.f65722b);
    }
}
