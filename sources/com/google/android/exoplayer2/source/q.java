package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

public final /* synthetic */ class q implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrmSessionManager f66046a;

    public /* synthetic */ q(DrmSessionManager drmSessionManager) {
        this.f66046a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return ProgressiveMediaSource.Factory.lambda$setDrmSessionManager$2(this.f66046a, mediaItem);
    }
}
