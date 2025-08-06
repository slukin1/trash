package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsListener.EventTime f65743a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65744b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f65745c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f65746d;

    public /* synthetic */ j(AnalyticsListener.EventTime eventTime, int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f65743a = eventTime;
        this.f65744b = i11;
        this.f65745c = positionInfo;
        this.f65746d = positionInfo2;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onPositionDiscontinuity$48(this.f65743a, this.f65744b, this.f65745c, this.f65746d, (AnalyticsListener) obj);
    }
}
