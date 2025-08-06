package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65769a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f65770b;

    public /* synthetic */ o0(AnalyticsListener.EventTime eventTime, String str) {
        this.f65769a = eventTime;
        this.f65770b = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioDecoderReleased(this.f65769a, this.f65770b);
    }
}
