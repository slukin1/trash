package com.tencent.ugc;

import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.ugc.videobase.base.GLConstants;

final /* synthetic */ class hf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50603a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayTarget f50604b;

    /* renamed from: c  reason: collision with root package name */
    private final GLConstants.GLScaleType f50605c;

    private hf(UGCVideoProcessor uGCVideoProcessor, DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        this.f50603a = uGCVideoProcessor;
        this.f50604b = displayTarget;
        this.f50605c = gLScaleType;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        return new hf(uGCVideoProcessor, displayTarget, gLScaleType);
    }

    public final void run() {
        UGCVideoProcessor.lambda$setDisplayView$4(this.f50603a, this.f50604b, this.f50605c);
    }
}
