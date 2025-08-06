package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65740a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoSize f65741b;

    public /* synthetic */ i0(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f65740a = eventTime;
        this.f65741b = videoSize;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onVideoSizeChanged$24(this.f65740a, this.f65741b, (AnalyticsListener) obj);
    }
}
