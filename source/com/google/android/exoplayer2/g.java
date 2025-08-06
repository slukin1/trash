package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65912a;

    public /* synthetic */ g(PlaybackInfo playbackInfo) {
        this.f65912a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlayerStateChanged(this.f65912a.playWhenReady, this.f65912a.playbackState);
    }
}
