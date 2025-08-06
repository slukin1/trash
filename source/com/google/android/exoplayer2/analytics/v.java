package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65800a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f65801b;

    public /* synthetic */ v(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f65800a = eventTime;
        this.f65801b = decoderCounters;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onAudioEnabled$5(this.f65800a, this.f65801b, (AnalyticsListener) obj);
    }
}
