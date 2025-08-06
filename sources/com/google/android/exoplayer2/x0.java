package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Timeline;

public final /* synthetic */ class x0 implements Bundleable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ x0 f66129a = new x0();

    public final Bundleable fromBundle(Bundle bundle) {
        return Timeline.Period.fromBundle(bundle);
    }
}
