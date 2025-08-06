package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65776a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaItem f65777b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65778c;

    public /* synthetic */ q(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i11) {
        this.f65776a = eventTime;
        this.f65777b = mediaItem;
        this.f65778c = i11;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMediaItemTransition(this.f65776a, this.f65777b, this.f65778c);
    }
}
