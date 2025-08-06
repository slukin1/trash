package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65910a;

    public /* synthetic */ f(PlaybackInfo playbackInfo) {
        this.f65910a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.lambda$updatePlaybackInfo$14(this.f65910a, (Player.EventListener) obj);
    }
}
