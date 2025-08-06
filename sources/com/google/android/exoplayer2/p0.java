package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Player;

public final /* synthetic */ class p0 implements Bundleable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ p0 f65970a = new p0();

    public final Bundleable fromBundle(Bundle bundle) {
        return Player.PositionInfo.fromBundle(bundle);
    }
}
