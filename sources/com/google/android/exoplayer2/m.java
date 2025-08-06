package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f65928a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionArray f65929b;

    public /* synthetic */ m(PlaybackInfo playbackInfo, TrackSelectionArray trackSelectionArray) {
        this.f65928a = playbackInfo;
        this.f65929b = trackSelectionArray;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onTracksChanged(this.f65928a.trackGroups, this.f65929b);
    }
}
