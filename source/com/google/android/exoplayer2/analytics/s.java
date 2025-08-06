package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65789a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f65790b;

    public /* synthetic */ s(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        this.f65789a = eventTime;
        this.f65790b = playbackParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlaybackParametersChanged(this.f65789a, this.f65790b);
    }
}
