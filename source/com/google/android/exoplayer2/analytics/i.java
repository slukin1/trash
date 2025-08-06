package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65736a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65737b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65738c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65739d;

    public /* synthetic */ i(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        this.f65736a = eventTime;
        this.f65737b = i11;
        this.f65738c = j11;
        this.f65739d = j12;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioUnderrun(this.f65736a, this.f65737b, this.f65738c, this.f65739d);
    }
}
