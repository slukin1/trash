package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f66128a;

    public /* synthetic */ x(MediaMetadata mediaMetadata) {
        this.f66128a = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onMediaMetadataChanged(this.f66128a);
    }
}
