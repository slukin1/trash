package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;

public final /* synthetic */ class t implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f65879a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnEventListener f65880b;

    public /* synthetic */ t(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener) {
        this.f65879a = frameworkMediaDrm;
        this.f65880b = onEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        this.f65879a.lambda$setOnEventListener$1(this.f65880b, mediaDrm, bArr, i11, i12, bArr2);
    }
}
