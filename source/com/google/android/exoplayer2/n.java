package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f65949a;

    public /* synthetic */ n(boolean z11) {
        this.f65949a = z11;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onShuffleModeEnabledChanged(this.f65949a);
    }
}
