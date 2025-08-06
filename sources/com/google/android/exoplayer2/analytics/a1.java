package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ExoFlags;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a1 implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsCollector f65688a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player f65689b;

    public /* synthetic */ a1(AnalyticsCollector analyticsCollector, Player player) {
        this.f65688a = analyticsCollector;
        this.f65689b = player;
    }

    public final void invoke(Object obj, ExoFlags exoFlags) {
        this.f65688a.lambda$setPlayer$1(this.f65689b, (AnalyticsListener) obj, exoFlags);
    }
}
