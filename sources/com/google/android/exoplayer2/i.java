package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65916a;

    public /* synthetic */ i(PlaybackInfo playbackInfo) {
        this.f65916a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlaybackParametersChanged(this.f65916a.playbackParameters);
    }
}
