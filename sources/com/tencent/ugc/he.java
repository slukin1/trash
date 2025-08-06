package com.tencent.ugc;

import com.tencent.ugc.videobase.base.GLConstants;

final /* synthetic */ class he implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50599a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50600b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50601c;

    /* renamed from: d  reason: collision with root package name */
    private final GLConstants.GLScaleType f50602d;

    private he(UGCVideoProcessor uGCVideoProcessor, int i11, int i12, GLConstants.GLScaleType gLScaleType) {
        this.f50599a = uGCVideoProcessor;
        this.f50600b = i11;
        this.f50601c = i12;
        this.f50602d = gLScaleType;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i11, int i12, GLConstants.GLScaleType gLScaleType) {
        return new he(uGCVideoProcessor, i11, i12, gLScaleType);
    }

    public final void run() {
        UGCVideoProcessor.lambda$setOutputSize$3(this.f50599a, this.f50600b, this.f50601c, this.f50602d);
    }
}
