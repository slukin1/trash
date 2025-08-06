package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;

public final /* synthetic */ class q {
    static {
        DrmSessionManager drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
    }

    public static DrmSessionManager.DrmSessionReference a(DrmSessionManager drmSessionManager, Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionManager.DrmSessionReference.EMPTY;
    }

    public static void b(DrmSessionManager drmSessionManager) {
    }

    public static void c(DrmSessionManager drmSessionManager) {
    }

    @Deprecated
    public static DrmSessionManager d() {
        return DrmSessionManager.DRM_UNSUPPORTED;
    }
}
