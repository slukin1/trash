package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ o f65950a = new o();

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onPlayerError(ExoPlaybackException.createForRenderer(new ExoTimeoutException(1)));
    }
}
