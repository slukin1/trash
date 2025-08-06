package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65783a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f65784b;

    public /* synthetic */ r(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f65783a = eventTime;
        this.f65784b = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMediaMetadataChanged(this.f65783a, this.f65784b);
    }
}
