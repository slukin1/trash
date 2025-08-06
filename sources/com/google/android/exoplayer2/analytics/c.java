package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65697b;

    public /* synthetic */ c(AnalyticsListener.EventTime eventTime, int i11) {
        this.f65696a = eventTime;
        this.f65697b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioSessionIdChanged(this.f65696a, this.f65697b);
    }
}
