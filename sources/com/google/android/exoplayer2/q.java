package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ q f65971a = new q();

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onSeekProcessed();
    }
}
