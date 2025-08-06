package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final /* synthetic */ class b implements Bundleable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ b f65848a = new b();

    public final Bundleable fromBundle(Bundle bundle) {
        return ExoPlaybackException.fromBundle(bundle);
    }
}
