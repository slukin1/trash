package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f66132a;

    public /* synthetic */ z(PlaybackInfo playbackInfo) {
        this.f66132a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onStaticMetadataChanged(this.f66132a.staticMetadata);
    }
}
