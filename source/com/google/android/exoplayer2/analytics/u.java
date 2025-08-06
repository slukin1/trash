package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65796a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f65797b;

    public /* synthetic */ u(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f65796a = eventTime;
        this.f65797b = decoderCounters;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onVideoEnabled$18(this.f65796a, this.f65797b, (AnalyticsListener) obj);
    }
}
