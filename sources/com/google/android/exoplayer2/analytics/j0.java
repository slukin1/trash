package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65747a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f65748b;

    public /* synthetic */ j0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f65747a = eventTime;
        this.f65748b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoCodecError(this.f65747a, this.f65748b);
    }
}
