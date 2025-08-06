package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65763a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f65764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65765c;

    public /* synthetic */ n0(AnalyticsListener.EventTime eventTime, Object obj, long j11) {
        this.f65763a = eventTime;
        this.f65764b = obj;
        this.f65765c = j11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onRenderedFirstFrame(this.f65763a, this.f65764b, this.f65765c);
    }
}
