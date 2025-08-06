package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f66092a;

    public /* synthetic */ v(ExoPlayerImpl exoPlayerImpl) {
        this.f66092a = exoPlayerImpl;
    }

    public final void invoke(Object obj) {
        this.f66092a.lambda$onMetadata$6((Player.EventListener) obj);
    }
}
