package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ExoFlags;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Player f65973a;

    public /* synthetic */ r(Player player) {
        this.f65973a = player;
    }

    public final void invoke(Object obj, ExoFlags exoFlags) {
        ((Player.EventListener) obj).onEvents(this.f65973a, new Player.Events(exoFlags));
    }
}
