package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f65861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f65862c;

    public /* synthetic */ g(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.f65861b = preacquiredSessionReference;
        this.f65862c = format;
    }

    public final void run() {
        this.f65861b.lambda$acquire$0(this.f65862c);
    }
}
