package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f66053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f66054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f66055c;

    public /* synthetic */ t(int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f66053a = i11;
        this.f66054b = positionInfo;
        this.f66055c = positionInfo2;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.lambda$updatePlaybackInfo$8(this.f66053a, this.f66054b, this.f66055c, (Player.EventListener) obj);
    }
}
