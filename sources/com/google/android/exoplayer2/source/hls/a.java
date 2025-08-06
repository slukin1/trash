package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;

public final /* synthetic */ class a implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrmSessionManager f66017a;

    public /* synthetic */ a(DrmSessionManager drmSessionManager) {
        this.f66017a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return HlsMediaSource.Factory.lambda$setDrmSessionManager$0(this.f66017a, mediaItem);
    }
}
