package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f65715b;

    public /* synthetic */ e1(AnalyticsListener.EventTime eventTime, float f11) {
        this.f65714a = eventTime;
        this.f65715b = f11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVolumeChanged(this.f65714a, this.f65715b);
    }
}
