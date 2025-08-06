package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f65926b;

    public /* synthetic */ l(PlaybackInfo playbackInfo, int i11) {
        this.f65925a = playbackInfo;
        this.f65926b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlayWhenReadyChanged(this.f65925a.playWhenReady, this.f65926b);
    }
}
