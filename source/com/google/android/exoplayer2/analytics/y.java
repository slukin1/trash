package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f65812b;

    public /* synthetic */ y(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f65811a = eventTime;
        this.f65812b = decoderCounters;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onVideoDisabled$23(this.f65811a, this.f65812b, (AnalyticsListener) obj);
    }
}
