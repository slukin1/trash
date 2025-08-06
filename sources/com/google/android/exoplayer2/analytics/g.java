package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65724b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65725c;

    public /* synthetic */ g(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        this.f65723a = eventTime;
        this.f65724b = i11;
        this.f65725c = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDroppedVideoFrames(this.f65723a, this.f65724b, this.f65725c);
    }
}
