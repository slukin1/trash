package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65792a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioAttributes f65793b;

    public /* synthetic */ t(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        this.f65792a = eventTime;
        this.f65793b = audioAttributes;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioAttributesChanged(this.f65792a, this.f65793b);
    }
}
