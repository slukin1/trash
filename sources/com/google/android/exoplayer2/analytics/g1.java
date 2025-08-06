package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65730b;

    public /* synthetic */ g1(AnalyticsListener.EventTime eventTime, int i11) {
        this.f65729a = eventTime;
        this.f65730b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackStateChanged(this.f65729a, this.f65730b);
    }
}
