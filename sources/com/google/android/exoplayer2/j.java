package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65918a;

    public /* synthetic */ j(PlaybackInfo playbackInfo) {
        this.f65918a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlaybackSuppressionReasonChanged(this.f65918a.playbackSuppressionReason);
    }
}
