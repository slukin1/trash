package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public final /* synthetic */ class i {
    public static boolean a(DrmSession drmSession) {
        return false;
    }

    public static void b(DrmSession drmSession, DrmSession drmSession2) {
        if (drmSession != drmSession2) {
            if (drmSession2 != null) {
                drmSession2.acquire((DrmSessionEventListener.EventDispatcher) null);
            }
            if (drmSession != null) {
                drmSession.release((DrmSessionEventListener.EventDispatcher) null);
            }
        }
    }
}
