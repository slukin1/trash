package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;

public final /* synthetic */ class u implements MediaDrm.OnExpirationUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f65881a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnExpirationUpdateListener f65882b;

    public /* synthetic */ u(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        this.f65881a = frameworkMediaDrm;
        this.f65882b = onExpirationUpdateListener;
    }

    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j11) {
        this.f65881a.lambda$setOnExpirationUpdateListener$3(this.f65882b, mediaDrm, bArr, j11);
    }
}
