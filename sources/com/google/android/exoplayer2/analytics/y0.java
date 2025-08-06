package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65813a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f65814b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65815c;

    public /* synthetic */ y0(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        this.f65813a = eventTime;
        this.f65814b = z11;
        this.f65815c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayWhenReadyChanged(this.f65813a, this.f65814b, this.f65815c);
    }
}
