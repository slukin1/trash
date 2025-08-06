package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65805a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f65806b;

    public /* synthetic */ w0(AnalyticsListener.EventTime eventTime, boolean z11) {
        this.f65805a = eventTime;
        this.f65806b = z11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onSkipSilenceEnabledChanged(this.f65805a, this.f65806b);
    }
}
