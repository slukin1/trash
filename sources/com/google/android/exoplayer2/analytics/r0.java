package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65785a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f65786b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65787c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65788d;

    public /* synthetic */ r0(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        this.f65785a = eventTime;
        this.f65786b = str;
        this.f65787c = j11;
        this.f65788d = j12;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onAudioDecoderInitialized$6(this.f65785a, this.f65786b, this.f65787c, this.f65788d, (AnalyticsListener) obj);
    }
}
