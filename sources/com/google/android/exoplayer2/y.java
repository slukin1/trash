package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f66130a;

    public /* synthetic */ y(PlaybackInfo playbackInfo) {
        this.f66130a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlayerError(this.f66130a.playbackError);
    }
}
