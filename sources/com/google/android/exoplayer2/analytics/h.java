package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65731a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65732b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65733c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65734d;

    public /* synthetic */ h(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        this.f65731a = eventTime;
        this.f65732b = i11;
        this.f65733c = j11;
        this.f65734d = j12;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onBandwidthEstimate(this.f65731a, this.f65732b, this.f65733c, this.f65734d);
    }
}
