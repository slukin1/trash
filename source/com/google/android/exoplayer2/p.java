package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f65969a;

    public /* synthetic */ p(int i11) {
        this.f65969a = i11;
    }

    public final void invoke(Object obj) {
        ((Player.EventListener) obj).onRepeatModeChanged(this.f65969a);
    }
}
