package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65922a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65923b;

    public /* synthetic */ k(PlaybackInfo playbackInfo, int i11) {
        this.f65922a = playbackInfo;
        this.f65923b = i11;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.lambda$updatePlaybackInfo$7(this.f65922a, this.f65923b, (Player.EventListener) obj);
    }
}
