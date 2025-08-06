package com.tencent.ugc.encoder;

import com.tencent.liteav.base.util.w;

final /* synthetic */ class y implements w.a {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50474a;

    public y(SurfaceInputVideoEncoder surfaceInputVideoEncoder) {
        this.f50474a = surfaceInputVideoEncoder;
    }

    public final void onTimeout() {
        this.f50474a.dequeueOutputBufferInternal();
    }
}
