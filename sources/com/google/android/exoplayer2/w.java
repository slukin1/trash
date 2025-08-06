package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class w implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f66125a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f66126b;

    public /* synthetic */ w(MediaItem mediaItem, int i11) {
        this.f66125a = mediaItem;
        this.f66126b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onMediaItemTransition(this.f66125a, this.f66126b);
    }
}
