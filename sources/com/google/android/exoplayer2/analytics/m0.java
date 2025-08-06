package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65759a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Exception f65760b;

    public /* synthetic */ m0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f65759a = eventTime;
        this.f65760b = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioCodecError(this.f65759a, this.f65760b);
    }
}
