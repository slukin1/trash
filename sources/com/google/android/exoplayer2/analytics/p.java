package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65771a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f65772b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f65773c;

    public /* synthetic */ p(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f65771a = eventTime;
        this.f65772b = format;
        this.f65773c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onVideoInputFormatChanged$20(this.f65771a, this.f65772b, this.f65773c, (AnalyticsListener) obj);
    }
}
