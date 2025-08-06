package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f65819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65820c;

    public /* synthetic */ z0(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        this.f65818a = eventTime;
        this.f65819b = z11;
        this.f65820c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerStateChanged(this.f65818a, this.f65819b, this.f65820c);
    }
}
