package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65756a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f65757b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65758c;

    public /* synthetic */ m(AnalyticsListener.EventTime eventTime, long j11, int i11) {
        this.f65756a = eventTime;
        this.f65757b = j11;
        this.f65758c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoFrameProcessingOffset(this.f65756a, this.f65757b, this.f65758c);
    }
}
