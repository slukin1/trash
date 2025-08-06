package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65807a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f65808b;

    public /* synthetic */ x(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f65807a = eventTime;
        this.f65808b = decoderCounters;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onAudioDisabled$11(this.f65807a, this.f65808b, (AnalyticsListener) obj);
    }
}
