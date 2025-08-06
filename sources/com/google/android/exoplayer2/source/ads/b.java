package com.google.android.exoplayer2.source.ads;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;

public final /* synthetic */ class b implements Bundleable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f65985a = new b();

    public final Bundleable fromBundle(Bundle bundle) {
        return AdPlaybackState.AdGroup.fromBundle(bundle);
    }
}
