package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65766a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Format f65767b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f65768c;

    public /* synthetic */ o(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f65766a = eventTime;
        this.f65767b = format;
        this.f65768c = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onAudioInputFormatChanged$7(this.f65766a, this.f65767b, this.f65768c, (AnalyticsListener) obj);
    }
}
