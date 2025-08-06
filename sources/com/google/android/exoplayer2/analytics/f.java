package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65716a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65717b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65718c;

    public /* synthetic */ f(AnalyticsListener.EventTime eventTime, int i11, int i12) {
        this.f65716a = eventTime;
        this.f65717b = i11;
        this.f65718c = i12;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSurfaceSizeChanged(this.f65716a, this.f65717b, this.f65718c);
    }
}
