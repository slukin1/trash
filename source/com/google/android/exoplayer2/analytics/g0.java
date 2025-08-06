package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65726a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackGroupArray f65727b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionArray f65728c;

    public /* synthetic */ g0(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.f65726a = eventTime;
        this.f65727b = trackGroupArray;
        this.f65728c = trackSelectionArray;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTracksChanged(this.f65726a, this.f65727b, this.f65728c);
    }
}
