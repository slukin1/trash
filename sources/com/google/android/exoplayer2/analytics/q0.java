package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65779a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f65780b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65781c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65782d;

    public /* synthetic */ q0(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        this.f65779a = eventTime;
        this.f65780b = str;
        this.f65781c = j11;
        this.f65782d = j12;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onVideoDecoderInitialized$19(this.f65779a, this.f65780b, this.f65781c, this.f65782d, (AnalyticsListener) obj);
    }
}
