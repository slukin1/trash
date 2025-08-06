package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65683a;

    public /* synthetic */ a0(PlaybackInfo playbackInfo) {
        this.f65683a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onIsPlayingChanged(ExoPlayerImpl.isPlaying(this.f65683a));
    }
}
