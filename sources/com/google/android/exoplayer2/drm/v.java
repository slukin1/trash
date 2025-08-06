package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import java.util.List;

public final /* synthetic */ class v implements MediaDrm.OnKeyStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f65883a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener f65884b;

    public /* synthetic */ v(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        this.f65883a = frameworkMediaDrm;
        this.f65884b = onKeyStatusChangeListener;
    }

    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z11) {
        this.f65883a.lambda$setOnKeyStatusChangeListener$2(this.f65884b, mediaDrm, bArr, list, z11);
    }
}
