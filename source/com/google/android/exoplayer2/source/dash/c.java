package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.dash.DashMediaSource;

public final /* synthetic */ class c implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrmSessionManager f66005a;

    public /* synthetic */ c(DrmSessionManager drmSessionManager) {
        this.f66005a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return DashMediaSource.Factory.lambda$setDrmSessionManager$0(this.f66005a, mediaItem);
    }
}
