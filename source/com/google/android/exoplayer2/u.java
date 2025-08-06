package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f66071a;

    public /* synthetic */ u(ExoPlayerImpl exoPlayerImpl) {
        this.f66071a = exoPlayerImpl;
    }

    public final void invoke(Object obj) {
        this.f66071a.lambda$updateAvailableCommands$21((Player.EventListener) obj);
    }
}
