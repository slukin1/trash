package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65761a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlaybackException f65762b;

    public /* synthetic */ n(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        this.f65761a = eventTime;
        this.f65762b = exoPlaybackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerError(this.f65761a, this.f65762b);
    }
}
