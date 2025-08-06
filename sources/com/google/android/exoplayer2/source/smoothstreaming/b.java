package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;

public final /* synthetic */ class b implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrmSessionManager f66050a;

    public /* synthetic */ b(DrmSessionManager drmSessionManager) {
        this.f66050a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return SsMediaSource.Factory.lambda$setDrmSessionManager$0(this.f66050a, mediaItem);
    }
}
