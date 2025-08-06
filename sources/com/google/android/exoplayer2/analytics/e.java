package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65710a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65711b;

    public /* synthetic */ e(AnalyticsListener.EventTime eventTime, int i11) {
        this.f65710a = eventTime;
        this.f65711b = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onRepeatModeChanged(this.f65710a, this.f65711b);
    }
}
