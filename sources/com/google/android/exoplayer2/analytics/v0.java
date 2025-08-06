package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65802a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f65803b;

    public /* synthetic */ v0(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f65802a = eventTime;
        this.f65803b = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onIsPlayingChanged(this.f65802a, this.f65803b);
    }
}
