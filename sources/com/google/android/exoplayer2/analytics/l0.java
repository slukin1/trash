package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65754a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f65755b;

    public /* synthetic */ l0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f65754a = eventTime;
        this.f65755b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmSessionManagerError(this.f65754a, this.f65755b);
    }
}
