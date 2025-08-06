package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Timeline;

public final /* synthetic */ class y0 implements Bundleable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ y0 f66131a = new y0();

    public final Bundleable fromBundle(Bundle bundle) {
        return Timeline.Window.fromBundle(bundle);
    }
}
