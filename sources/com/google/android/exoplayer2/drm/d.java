package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f65858a = new d();

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysRemoved();
    }
}
