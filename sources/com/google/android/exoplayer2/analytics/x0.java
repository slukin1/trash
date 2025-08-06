package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65809a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f65810b;

    public /* synthetic */ x0(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f65809a = eventTime;
        this.f65810b = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onShuffleModeChanged(this.f65809a, this.f65810b);
    }
}
